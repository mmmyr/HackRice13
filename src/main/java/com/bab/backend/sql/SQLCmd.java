package com.bab.backend.sql;

import org.apache.ibatis.jdbc.SQL;

public class SQLCmd {

    public String getUser(){
        return new SQL()
                .SELECT("*")
                .FROM("user")
                .WHERE("username = #{username}")
                .toString();
    }

    public String userGetUid(){
        return new SQL()
                .SELECT("uid")
                .FROM("user")
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

}
