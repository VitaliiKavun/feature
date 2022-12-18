package com.example.featureflag.service;

import com.example.featureflag.domain.Accessibility;
import com.example.featureflag.domain.Feature;
import com.example.featureflag.domain.dto.feature.FeatureInputDto;
import com.example.featureflag.domain.dto.feature.FeatureOutputDto;
import com.example.featureflag.domain.security.UserEntity;
import com.example.featureflag.repository.security.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeatureDtoService {

    private final UserDtoService userDtoService;
    private final UserRepository userRepository;

    public FeatureOutputDto toDto(Feature feature) {
        return FeatureOutputDto.builder()
                .id(feature.getId())
                .accessability(feature.getAccessability())
                .userEntities(feature.getUserEntities().stream()
                        .map(user -> userDtoService.toDto(user))
                        .collect(Collectors.toSet()))
                .name(feature.getName())
                .build();
    }

    public Feature toEntity(FeatureInputDto featureDto) {

        //check accessibility type
        Accessibility accessibility = Accessibility.of(featureDto.getAccessibility());
        //if accessibility type is GROUP - get all users of specific GROUP
        List<UserEntity> users = getUsersWithAccessibility(accessibility);


//        return Feature.builder()
//                .userEntities(featureDto.getUserEntities().stream()
//                        .map(userDto -> userDtoService.toEntity(userDto))
//                        .collect(Collectors.toSet()))
//                .id(featureDto.getId())
//                .name(featureDto.getName())
//                .accessability(featureDto.getAccessability())
//                .build();

        return null;
    }

    private List<UserEntity> getUsersWithAccessibility(Accessibility accessibility) {

    }
}
