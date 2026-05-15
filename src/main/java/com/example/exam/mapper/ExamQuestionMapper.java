
package com.example.exam.mapper;

import com.example.exam.entity.ExamQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamQuestionMapper {
    void addExamQuestion(ExamQuestion examQuestion);
    List<Integer> getQuestionIdsByExamId(Integer examId);
    void deleteExamQuestion(Integer examId);
}
