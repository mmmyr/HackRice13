package com.bab.backend;

import com.bab.backend.entity.User;
import com.bab.backend.mapper.SleepMapper;
import com.bab.backend.mapper.UserMapper;
import com.bab.backend.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(BackendApplication.class, args);
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
////        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
////        User ada = userMapper.getUser("ada");
////        System.out.println(ada.getPassword());
//
//        SleepMapper sleepMapper = sqlSession.getMapper(SleepMapper.class);
//        Date localDate = Date.valueOf(LocalDate.now());
//        sleepMapper.initSleep(1, localDate);
//
//
//        sqlSession.close();


    }

}
