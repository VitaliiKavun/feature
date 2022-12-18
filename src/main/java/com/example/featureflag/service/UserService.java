package com.example.featureflag.service;

import com.example.featureflag.domain.dto.user.UserDto;
import com.example.featureflag.domain.security.UserEntity;
import com.example.featureflag.repository.security.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoService userDtoService;

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream()
                .map(user -> userDtoService.toDto(user))
                .collect(Collectors.toList());
    }

    public UserDto getUser(Integer id) {
        UserEntity user = userRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(String.format("User with id %d not found", id))
        );
        return userDtoService.toDto(user);
    }
}
