package com.bab.backend.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.sql.Date;

@Mapper
public interface MoodMapper {

    @Update("CREATE TABLE ${tableName} (id INT PRIMARY KEY, score INT, ans_date DATE)")
    void createTable(@Param("tableName") String tableName);

    @Insert("insert into ada_mood_table (score, ans_date) VALUES (#{score}, #{ans_date})")
    void insertMoodData(int score, Date ans_date);

}
