package com.example.exam.service;

import com.example.exam.entity.Score;
import com.example.exam.entity.ScoreLog;
import java.util.List;
import java.util.Map;

public interface ScoreService {
    int calculateScore(Integer examId, Map<Integer, String> answers);
    void saveScore(Integer userId, Integer examId, Integer score);
    List<Score> getScoresByUserId(Integer userId);
    Score getScoreByUserIdAndExamId(Integer userId, Integer examId);
    List<Score> getAllScores();
    List<ScoreLog> getAllScoreLogs();
}
