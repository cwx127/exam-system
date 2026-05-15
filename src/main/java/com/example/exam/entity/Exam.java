
package com.example.exam.entity;

public class Exam {
    private Integer examId;
    private String examName;
    private Integer duration;

    public Exam() {}

    public Integer getExamId() { return examId; }
    public void setExamId(Integer examId) { this.examId = examId; }
    public String getExamName() { return examName; }
    public void setExamName(String examName) { this.examName = examName; }
    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }
}
