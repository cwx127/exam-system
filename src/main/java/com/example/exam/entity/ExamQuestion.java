
package com.example.exam.entity;

public class ExamQuestion {
    private Integer examId;
    private Integer questionId;

    public ExamQuestion() {}

    public ExamQuestion(Integer examId, Integer questionId) {
        this.examId = examId;
        this.questionId = questionId;
    }

    public Integer getExamId() { return examId; }
    public void setExamId(Integer examId) { this.examId = examId; }
    public Integer getQuestionId() { return questionId; }
    public void setQuestionId(Integer questionId) { this.questionId = questionId; }
}
