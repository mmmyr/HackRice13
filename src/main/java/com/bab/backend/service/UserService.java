package com.bab.backend.service;

import com.bab.backend.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    User getUser(String username);

    int userGetUid(String username);

    void registerUser(String username, String password);

    String getPassword(String username);


}