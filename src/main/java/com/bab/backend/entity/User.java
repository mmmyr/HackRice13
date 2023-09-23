package com.bab.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    int uid;
    String username;
    String password;

}
