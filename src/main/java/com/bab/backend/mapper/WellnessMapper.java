package com.bab.backend.mapper;

import com.bab.backend.sql.SQLCmd;
import org.apache.ibatis.annotations.*;

import java.sql.Date;

@Mapper
public interface WellnessMapper {
    @Update("CREATE TABLE ${tableName} (id INT AUTO_INCREMENT PRIMARY KEY , score INT, ans_date DATE)")
    void createTable(@Param("tableName") String tableName);

    @Select("SHOW TABLES LIKE 'ada_wellness_table'")
    String getTableNameIfExists();

    @Insert("insert into ada_wellness_table (score, ans_date) VALUES (#{score}, #{ans_date})")
    void insertMoodData(int score, Date ans_date);
}
