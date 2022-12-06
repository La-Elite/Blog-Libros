package com.spring.infrastructure.repository.user;

import com.spring.domain.User;
import com.spring.infrastructure.entities.UserEntity;
import com.spring.service.UserService;
import com.spring.service.UserStorer;
import org.springframework.stereotype.Repository;

@Repository
public class UserManager implements UserStorer, UserService {

    private final UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        var userEntity = new UserEntity(user.getId(), user.getPass());
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity getUser(UserEntity user) {
        return userRepository.findById(user.getId()).orElse(null);
    }

    @Override
    public UserEntity listUserById(String id) {
        return userRepository.findById(id).get();
    }
}
