
package com.example.exam.mapper;

import com.example.exam.entity.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScoreMapper {
    void addScore(Score score);
    List<Score> getScoresByUserId(Integer userId);
    Score getScoreByUserIdAndExamId(Integer userId, Integer examId);
    List<Score> getAllScores();
    void updateScore(Score score);
}
