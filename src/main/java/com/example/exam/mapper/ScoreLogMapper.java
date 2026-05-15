package com.example.exam.mapper;

import com.example.exam.entity.ScoreLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScoreLogMapper {
    @Insert("INSERT INTO score_log (score_id, user_id, exam_id, score, operation) VALUES (#{scoreId}, #{userId}, #{examId}, #{score}, #{operation})")
    void addScoreLog(ScoreLog scoreLog);

    @Select("SELECT * FROM score_log ORDER BY operation_time DESC")
    List<ScoreLog> getAllScoreLogs();

    @Select("SELECT * FROM score_log WHERE user_id = #{userId} ORDER BY operation_time DESC")
    List<ScoreLog> getScoreLogsByUserId(Integer userId);
}
