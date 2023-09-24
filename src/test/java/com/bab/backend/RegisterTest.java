package com.bab.backend;

import com.bab.backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RegisterTest {
    @Autowired
    UserService userService;
    @Test
    void registerTest(){
        userService.registerUser("Benson", "Ning");
    }
}
