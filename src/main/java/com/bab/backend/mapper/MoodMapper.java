package com.bab.backend.mapper;

import org.apache.ibatis.annotations.*;

import java.sql.Date;

@Mapper
public interface MoodMapper {

    @Select("SHOW TABLES LIKE 'ada_mood_table'")
    String getTableNameIfExists();

    @Update("CREATE TABLE ${tableName} (id INT AUTO_INCREMENT PRIMARY KEY, score INT, ans_date DATE)")
    void createTable(@Param("tableName") String tableName);

    @Insert("insert into ada_mood_table (score, ans_date) VALUES (#{score}, #{ans_date})")
    void insertMoodData(int score, Date ans_date);



}
