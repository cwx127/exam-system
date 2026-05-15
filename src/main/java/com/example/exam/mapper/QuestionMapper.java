
package com.example.exam.mapper;

import com.example.exam.entity.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {
    void addQuestion(Question question);
    List<Question> getAllQuestions();
    Question getQuestionById(Integer questionId);
    void updateQuestion(Question question);
    void deleteQuestion(Integer questionId);
}
