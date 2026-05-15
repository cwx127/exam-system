
package com.example.exam.controller;

import com.example.exam.entity.Score;
import com.example.exam.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @PostMapping("/submit")
    public Map<String, Object> submitExam(@RequestBody Map<String, Object> request) {
        Map<String, Object> result = new HashMap<>();
        try {
            Integer userId = (Integer) request.get("userId");
            Integer examId = (Integer) request.get("examId");
            Map<Integer, String> answers = (Map<Integer, String>) request.get("answers");
            
            int score = scoreService.calculateScore(examId, answers);
            scoreService.saveScore(userId, examId, score);
            
            result.put("success", true);
            result.put("message", "提交成功");
            result.put("score", score);
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "提交失败：" + e.getMessage());
        }
        return result;
    }

    @GetMapping("/user/{userId}")
    public List<Score> getScoresByUserId(@PathVariable Integer userId) {
        return scoreService.getScoresByUserId(userId);
    }

    @GetMapping("/user/{userId}/exam/{examId}")
    public Score getScoreByUserIdAndExamId(@PathVariable Integer userId, @PathVariable Integer examId) {
        return scoreService.getScoreByUserIdAndExamId(userId, examId);
    }

    @GetMapping("/list")
    public List<Score> getAllScores() {
        return scoreService.getAllScores();
    }
}
