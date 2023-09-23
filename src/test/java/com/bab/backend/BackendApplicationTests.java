package com.bab.backend;

import com.bab.backend.entity.User;
import com.bab.backend.mapper.UserMapper;

import com.bab.backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
    class BackendApplicationTests {
    @Autowired
    UserService userService;

   @Test
    void loadUser(){
        User ada = userService.getUser("ada");
       System.out.println(ada.getPassword());

    }

    @Test
   void getUid(){
       int adaId = userService.userGetUid("ada");
        System.out.println(adaId);
    }



}
