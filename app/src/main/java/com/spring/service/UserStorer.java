package com.spring.service;

import com.spring.domain.User;
import com.spring.infrastructure.entities.UserEntity;

public interface UserStorer {

    void registerUser(User user);
    UserEntity getUser(UserEntity user);
}
