
package com.example.exam.entity;

public class Score {
    private Integer scoreId;
    private Integer userId;
    private Integer examId;
    private Integer score;

    public Score() {}

    public Integer getScoreId() { return scoreId; }
    public void setScoreId(Integer scoreId) { this.scoreId = scoreId; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public Integer getExamId() { return examId; }
    public void setExamId(Integer examId) { this.examId = examId; }
    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }
}
