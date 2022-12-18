package com.example.featureflag.controller;

import com.example.featureflag.domain.dto.user.UserDto;
import com.example.featureflag.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity getUserList() {
        List<UserDto> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(userService.getUser(id));
    }
}
