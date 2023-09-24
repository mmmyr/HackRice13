package com.bab.backend.mapper;

import com.bab.backend.entity.Mood;
import com.bab.backend.entity.Wellness;
import com.bab.backend.sql.SQLCmd;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;

@Mapper
public interface WellnessMapper {
    @Update("CREATE TABLE ${username}_Wellness_table (id INT AUTO_INCREMENT PRIMARY KEY, score INT, ans_date DATE)")
    void createTable(@Param("username") String username);
    @Select("SHOW TABLES LIKE '${username}_wellness_table'")
    String getTableNameIfExists(@Param("username") String username);

    @Insert("insert into ${username}_wellness_table (score, ans_date) VALUES (#{score}, #{ans_date})")
    void insertWellnessData(@Param("username") String username, int score, Date ans_date);

    @Select("SELECT score FROM ${username}_wellness_table ORDER BY id DESC LIMIT ${days}")
    List<Wellness> getWellnessData(@Param("username") String username, int days);
}
