
package com.example.exam.controller;

import com.example.exam.entity.Exam;
import com.example.exam.entity.Question;
import com.example.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/exam")
public class ExamController {
    @Autowired
    private ExamService examService;

    @PostMapping("/add")
    public Map<String, Object> addExam(@RequestBody Map<String, Object> request) {
        Map<String, Object> result = new HashMap<>();
        try {
            Exam exam = new Exam();
            exam.setExamName((String) request.get("examName"));
            exam.setDuration((Integer) request.get("duration"));
            List<Integer> questionIds = (List<Integer>) request.get("questionIds");
            examService.addExam(exam, questionIds);
            result.put("success", true);
            result.put("message", "创建试卷成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "创建试卷失败：" + e.getMessage());
        }
        return result;
    }

    @GetMapping("/list")
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }

    @GetMapping("/{examId}")
    public Exam getExamById(@PathVariable Integer examId) {
        return examService.getExamById(examId);
    }

    @GetMapping("/{examId}/questions")
    public List<Question> getQuestionsByExamId(@PathVariable Integer examId) {
        return examService.getQuestionsByExamId(examId);
    }

    @PutMapping("/update")
    public Map<String, Object> updateExam(@RequestBody Exam exam) {
        Map<String, Object> result = new HashMap<>();
        try {
            examService.updateExam(exam);
            result.put("success", true);
            result.put("message", "更新试卷成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "更新试卷失败：" + e.getMessage());
        }
        return result;
    }

    @DeleteMapping("/delete/{examId}")
    public Map<String, Object> deleteExam(@PathVariable Integer examId) {
        Map<String, Object> result = new HashMap<>();
        try {
            examService.deleteExam(examId);
            result.put("success", true);
            result.put("message", "删除试卷成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "删除试卷失败：" + e.getMessage());
        }
        return result;
    }
}
