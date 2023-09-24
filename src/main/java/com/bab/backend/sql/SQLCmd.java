package com.bab.backend.sql;

import org.apache.ibatis.jdbc.SQL;

public class SQLCmd {

    public String getUser(){
        return new SQL()
                .SELECT("*")
                .FROM("users")
                .WHERE("username = #{username}")
                .toString();
    }

    public String userGetUid(){
        return new SQL()
                .SELECT("uid")
                .FROM("users")
                .WHERE("username = #{username}")
                .toString();
    }

    public String initSleep(){
        return new SQL()
                .INSERT_INTO("sleep")
                .INTO_COLUMNS("uid","create_date")
                .INTO_VALUES("#{uid}", "#{create_date}")
                .toString();
    }

    public String getSleepUid(){
        return new SQL()
                .SELECT("uid")
                .FROM("sleep")
                .WHERE("username = #{username}")
                .toString();
    }
    public String getSleepCreateDate(){
        return new SQL()
                .SELECT("create_date")
                .FROM("sleep")
                .WHERE("uid = #{uid}")
                .toString();
    }

    public String sleepUpdate(){
        return new SQL()
                .INSERT_INTO("sleep")
                .INTO_COLUMNS("score")
                .INTO_VALUES("newScore")
                .toString();
    }

    public String insertSleepData(){
        return new SQL()
                .INSERT_INTO("ada_sleep_table")
                .INTO_COLUMNS("score", "ans_date")
                .INTO_VALUES("#{score}","#{ans_date}")
                .toString();
    }



}
