package com.example.featureflag.repository.security;

import com.example.featureflag.domain.security.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUserName(String userName);


}
