package com.spring.service;

import com.spring.infrastructure.entities.UserEntity;

public interface UserService {

    UserEntity listUserById(String id);

}
