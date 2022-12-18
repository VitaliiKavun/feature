package com.example.featureflag.domain.dto.feature;

import com.example.featureflag.domain.Accessibility;
import com.example.featureflag.domain.dto.user.UserDto;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Set;


@Getter
@Setter
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeatureOutputDto {
    private Integer id;
    private String name;
    private Set<UserDto> userEntities;
    private Accessibility accessability;
}
