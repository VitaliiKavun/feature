package com.example.featureflag.repository.security;

import com.example.featureflag.domain.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    Optional<Authority> findByRole(String role);
}
