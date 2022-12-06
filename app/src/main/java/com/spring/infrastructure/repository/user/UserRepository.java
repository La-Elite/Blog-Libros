package com.spring.infrastructure.repository.user;

import com.spring.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity,String> {
}
