package com.bab.backend.mapper;

import com.bab.backend.entity.User;
import com.bab.backend.sql.SQLCmd;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @SelectProvider(type = SQLCmd.class, method = "getUser")
    User getUser(String username);

    @SelectProvider(type = SQLCmd.class, method = "userGetUid")
    int userGetUid(String username);

    @Insert("INSERT INTO users (username, password) VALUES (#{username}, #{password})")
    void registerUser(@Param("username") String username, @Param("password") String password);

    @Select("SELECT password FROM users WHERE username = #{username}")
    String getPassword(@Param("password") String password);




}
