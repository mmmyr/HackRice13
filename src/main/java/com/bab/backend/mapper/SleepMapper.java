package com.bab.backend.mapper;

import com.bab.backend.entity.Sleep;
import com.bab.backend.sql.SQLCmd;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface SleepMapper {

    @Update("CREATE TABLE ${tableName} (id INT AUTO_INCREMENT PRIMARY KEY, score INT, ans_date DATE)")
    void createTable(@Param("tableName") String tableName);

    @Select("SHOW TABLES LIKE 'ada_sleep_table'")
    String getTableNameIfExists();

    @SelectProvider(type = SQLCmd.class, method = "insertSleepData")
    void insertSleepData(int score, Date ans_date);

    @Select("SELECT score FROM ada_sleep_table ORDER BY id DESC LIMIT ${days}")
    List<Sleep> getSleepData(int days);

}
