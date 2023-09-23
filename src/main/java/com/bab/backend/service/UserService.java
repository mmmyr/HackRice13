package com.bab.backend.service;

import com.bab.backend.entity.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    @Transactional
    User getUser(String username);
}
