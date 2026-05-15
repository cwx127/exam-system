
package com.example.exam.service.impl;

import com.example.exam.entity.Exam;
import com.example.exam.entity.ExamQuestion;
import com.example.exam.entity.Question;
import com.example.exam.mapper.ExamMapper;
import com.example.exam.mapper.ExamQuestionMapper;
import com.example.exam.mapper.QuestionMapper;
import com.example.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private ExamQuestionMapper examQuestionMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    @Transactional
    public void addExam(Exam exam, List<Integer> questionIds) {
        examMapper.addExam(exam);
        Integer examId = getLastExamId();
        for (Integer questionId : questionIds) {
            examQuestionMapper.addExamQuestion(new ExamQuestion(examId, questionId));
        }
    }

    private Integer getLastExamId() {
        List<Exam> exams = examMapper.getAllExams();
        return exams.get(exams.size() - 1).getExamId();
    }

    @Override
    public List<Exam> getAllExams() {
        return examMapper.getAllExams();
    }

    @Override
    public Exam getExamById(Integer examId) {
        return examMapper.getExamById(examId);
    }

    @Override
    public void updateExam(Exam exam) {
        examMapper.updateExam(exam);
    }

    @Override
    @Transactional
    public void deleteExam(Integer examId) {
        examQuestionMapper.deleteExamQuestion(examId);
        examMapper.deleteExam(examId);
    }

    @Override
    public List<Question> getQuestionsByExamId(Integer examId) {
        List<Integer> questionIds = examQuestionMapper.getQuestionIdsByExamId(examId);
        List<Question> questions = new ArrayList<>();
        for (Integer questionId : questionIds) {
            questions.add(questionMapper.getQuestionById(questionId));
        }
        return questions;
    }
}
