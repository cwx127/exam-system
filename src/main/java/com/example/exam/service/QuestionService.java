
package com.example.exam.service;

import com.example.exam.entity.Question;
import java.util.List;

public interface QuestionService {
    void addQuestion(Question question);
    List<Question> getAllQuestions();
    Question getQuestionById(Integer questionId);
    void updateQuestion(Question question);
    void deleteQuestion(Integer questionId);
}
