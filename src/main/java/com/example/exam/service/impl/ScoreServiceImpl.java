package com.example.exam.service.impl;

import com.example.exam.entity.Question;
import com.example.exam.entity.Score;
import com.example.exam.entity.ScoreLog;
import com.example.exam.mapper.ScoreLogMapper;
import com.example.exam.mapper.ScoreMapper;
import com.example.exam.service.ExamService;
import com.example.exam.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private ScoreLogMapper scoreLogMapper;

    @Autowired
    private ExamService examService;

    @Override
    public int calculateScore(Integer examId, Map<Integer, String> answers) {
        List<Question> questions = examService.getQuestionsByExamId(examId);
        int score = 0;
        int totalQuestions = questions.size();
        
        for (Question question : questions) {
            String userAnswer = answers.get(question.getQuestionId());
            if (userAnswer == null) {
                String stringKey = String.valueOf(question.getQuestionId());
                for (Map.Entry<Integer, String> entry : answers.entrySet()) {
                    if (String.valueOf(entry.getKey()).equals(stringKey)) {
                        userAnswer = entry.getValue();
                        break;
                    }
                }
            }
            if (userAnswer != null && userAnswer.equals(question.getAnswer())) {
                score++;
            }
        }
        
        if (totalQuestions > 0) {
            return (score * 100) / totalQuestions;
        }
        return 0;
    }

    @Override
    public void saveScore(Integer userId, Integer examId, Integer score) {
        Score existingScore = scoreMapper.getScoreByUserIdAndExamId(userId, examId);
        if (existingScore == null) {
            Score newScore = new Score();
            newScore.setUserId(userId);
            newScore.setExamId(examId);
            newScore.setScore(score);
            scoreMapper.addScore(newScore);
            
            Score savedScore = scoreMapper.getScoreByUserIdAndExamId(userId, examId);
            if (savedScore != null) {
                ScoreLog log = new ScoreLog();
                log.setScoreId(savedScore.getScoreId());
                log.setUserId(userId);
                log.setExamId(examId);
                log.setScore(score);
                log.setOperation("INSERT");
                scoreLogMapper.addScoreLog(log);
            }
        } else {
            Integer oldScore = existingScore.getScore();
            existingScore.setScore(score);
            scoreMapper.updateScore(existingScore);
            
            ScoreLog log = new ScoreLog();
            log.setScoreId(existingScore.getScoreId());
            log.setUserId(userId);
            log.setExamId(examId);
            log.setScore(score);
            log.setOperation("UPDATE");
            scoreLogMapper.addScoreLog(log);
        }
    }

    @Override
    public List<Score> getScoresByUserId(Integer userId) {
        return scoreMapper.getScoresByUserId(userId);
    }

    @Override
    public Score getScoreByUserIdAndExamId(Integer userId, Integer examId) {
        return scoreMapper.getScoreByUserIdAndExamId(userId, examId);
    }

    @Override
    public List<Score> getAllScores() {
        return scoreMapper.getAllScores();
    }

    @Override
    public List<ScoreLog> getAllScoreLogs() {
        return scoreLogMapper.getAllScoreLogs();
    }
}
