
package com.example.exam.service;

import com.example.exam.entity.Exam;
import com.example.exam.entity.Question;
import java.util.List;

public interface ExamService {
    void addExam(Exam exam, List<Integer> questionIds);
    List<Exam> getAllExams();
    Exam getExamById(Integer examId);
    void updateExam(Exam exam);
    void deleteExam(Integer examId);
    List<Question> getQuestionsByExamId(Integer examId);
}
