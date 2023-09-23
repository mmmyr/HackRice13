package com.bab.backend.service.impl;

import com.bab.backend.entity.User;
import com.bab.backend.mapper.UserMapper;
import com.bab.backend.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
//@NoArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser(String username) {
        return userMapper.getUser(username);
    }
}
