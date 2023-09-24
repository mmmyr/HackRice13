package com.bab.backend.mapper;

import com.bab.backend.entity.Sleep;
import com.bab.backend.sql.SQLCmd;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface SleepMapper {

    @Update("CREATE TABLE ${username}_sleep_table (id INT AUTO_INCREMENT PRIMARY KEY, score INT, ans_date DATE)")
    void createTable(@Param("username") String username);

    @Select("SHOW TABLES LIKE '${username}_sleep_table'")
    String getTableNameIfExists(@Param("username") String username);

    @Insert("insert into ${username}_sleep_table (score, ans_date) VALUES (#{score}, #{ans_date})")
    void insertSleepData(@Param("username") String username, int score, Date ans_date);

    @Select("SELECT score FROM ${username}_sleep_table ORDER BY id DESC LIMIT ${days}")
    List<Sleep> getSleepData(@Param("username") String username, int days);



}
