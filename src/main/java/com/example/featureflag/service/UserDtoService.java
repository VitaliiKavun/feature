package com.example.featureflag.service;

import com.example.featureflag.domain.dto.user.UserDto;
import com.example.featureflag.domain.security.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserDtoService {
    public UserEntity toEntity(UserDto userDto) {
        return UserEntity.builder()
                .id(userDto.getId())
                .userName(userDto.getUserName())
                .password(userDto.getUserName())
                .authorities(userDto.getAuthorities())
                .build();
    }

    public UserDto toDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .userName(userEntity.getUserName())
                .password(userEntity.getPassword())
                .authorities(userEntity.getAuthorities())
                .build();
    }
}
