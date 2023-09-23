package com.bab.backend.mapper;

import com.bab.backend.sql.SQLCmd;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface SleepMapper {
    @SelectProvider(type = SQLCmd.class, method = "initSleep")
    void initSleep(int uid, Date create_date);

    @SelectProvider(type = SQLCmd.class, method = "getSleepCreateDate")
    Date getSleepCreateDate(int uid);

//    @SelectProvider(type = SQLCmd.class, method = "sleepUpdate")
//    List<Map<Date, Integer>>
    @Update("CREATE TABLE ${tableName} (id INT PRIMARY KEY, score INT, ans_date DATE)")
    void createTable(@Param("tableName") String tableName);

    @SelectProvider(type = SQLCmd.class, method = "insertSleepData")
    void insertSleepData(int score, Date ans_date);

}
