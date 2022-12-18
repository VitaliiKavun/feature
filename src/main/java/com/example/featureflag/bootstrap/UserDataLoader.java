package com.example.featureflag.bootstrap;

import com.example.featureflag.domain.security.Authority;
import com.example.featureflag.domain.security.UserEntity;
import com.example.featureflag.repository.security.AuthorityRepository;
import com.example.featureflag.repository.security.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (authorityRepository.count() == 0) {
            loadData();
        }
    }

    private void loadData() {
        Authority admin = authorityRepository.save(Authority.builder().role("ROLE_ADMIN").build());
        Authority user = authorityRepository.save(Authority.builder().role("ROLE_USER").build());

        userRepository.save(UserEntity.builder()
                .userName("admin")
                .password(passwordEncoder.encode("admin"))
                .authority(admin)
                .build()
        );

        userRepository.save(UserEntity.builder()
                .userName("user1")
                .password(passwordEncoder.encode("pass1"))
                .authority(user)
                .build()
        );

        userRepository.save(UserEntity.builder()
                .userName("user2")
                .password(passwordEncoder.encode("pass2"))
                .authority(user)
                .build()
        );
        log.info("Users are loaded: " + userRepository.count());
    }
}
