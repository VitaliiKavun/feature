package com.example.featureflag.domain.dto.user;

import com.example.featureflag.domain.security.Authority;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class UserDto {
    private Integer id;
    private String userName;
    private String password;
    private Set<Authority> authorities;
}
