package com.example.featureflag.domain.dto.feature;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeatureInputDto {
    private String name;
    private String accessibility;
    private List<String> users;
}
