
package com.example.exam.controller;

import com.example.exam.entity.Question;
import com.example.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/add")
    public Map<String, Object> addQuestion(@RequestBody Question question) {
        Map<String, Object> result = new HashMap<>();
        try {
            questionService.addQuestion(question);
            result.put("success", true);
            result.put("message", "添加题目成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "添加题目失败：" + e.getMessage());
        }
        return result;
    }

    @GetMapping("/list")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{questionId}")
    public Question getQuestionById(@PathVariable Integer questionId) {
        return questionService.getQuestionById(questionId);
    }

    @PutMapping("/update")
    public Map<String, Object> updateQuestion(@RequestBody Question question) {
        Map<String, Object> result = new HashMap<>();
        try {
            questionService.updateQuestion(question);
            result.put("success", true);
            result.put("message", "更新题目成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "更新题目失败：" + e.getMessage());
        }
        return result;
    }

    @DeleteMapping("/delete/{questionId}")
    public Map<String, Object> deleteQuestion(@PathVariable Integer questionId) {
        Map<String, Object> result = new HashMap<>();
        try {
            questionService.deleteQuestion(questionId);
            result.put("success", true);
            result.put("message", "删除题目成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "删除题目失败：" + e.getMessage());
        }
        return result;
    }
}
