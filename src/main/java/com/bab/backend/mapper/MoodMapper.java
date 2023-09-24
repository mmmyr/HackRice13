package com.bab.backend.mapper;

import com.bab.backend.entity.Mood;
import com.bab.backend.entity.Sleep;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;

@Mapper
public interface MoodMapper {


    @Update("CREATE TABLE ${username}_Mood_table (id INT AUTO_INCREMENT PRIMARY KEY, score INT, ans_date DATE)")
    void createTable(@Param("username") String username);
    @Select("SHOW TABLES LIKE '${username}_mood_table'")
    String getTableNameIfExists(@Param("username") String username);

    @Insert("insert into ${username}_mood_table (score, ans_date) VALUES (#{score}, #{ans_date})")
    void insertMoodData(@Param("username") String username, int score, Date ans_date);

    @Select("SELECT score FROM ${username}_mood_table ORDER BY id DESC LIMIT ${days}")
    List<Mood> getMoodData(@Param("username") String username,int days);



}
