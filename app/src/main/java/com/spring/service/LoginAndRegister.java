package com.spring.service;

import com.spring.domain.User;
import com.spring.infrastructure.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginAndRegister {

    private final UserStorer userStorer;

    public LoginAndRegister(UserStorer userStorer) {
        this.userStorer = userStorer;
    }

    public void saveUser(String user, String pass) {
        var newUser = new User(user, pass);
        userStorer.registerUser(newUser);
    }

    public User getUser(String user, String pass) {
        var rs = userStorer.getUser(new UserEntity(user, pass));
        if (rs == null) {
            return null;
        } else {
            return new User(rs.getId(), rs.getPass());
        }
    }
}
