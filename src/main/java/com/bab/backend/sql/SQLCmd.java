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
}
