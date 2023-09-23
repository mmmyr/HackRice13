package com.bab.backend.mapper;

import com.bab.backend.sql.SQLCmd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.sql.Date;

@Mapper
public interface SleepMapper {
    @SelectProvider(type = SQLCmd.class, method = "initSleep")
    void initSleep(int uid, Date create_date);

}
