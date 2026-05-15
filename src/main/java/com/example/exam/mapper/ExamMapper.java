
package com.example.exam.mapper;

import com.example.exam.entity.Exam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamMapper {
    void addExam(Exam exam);
    List<Exam> getAllExams();
    Exam getExamById(Integer examId);
    void updateExam(Exam exam);
    void deleteExam(Integer examId);
}
