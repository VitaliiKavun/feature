package com.example.featureflag.service;

import com.example.featureflag.domain.Feature;
import com.example.featureflag.domain.dto.feature.FeatureInputDto;
import com.example.featureflag.domain.dto.feature.FeatureOutputDto;
import com.example.featureflag.repository.FeatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeatureService {

    private final FeatureRepository featureRepository;
    private final FeatureDtoService featureDtoService;

    public List<FeatureOutputDto> getFeatures() {
        return featureRepository.findAll().stream()
                .map(feature -> featureDtoService.toDto(feature))
                .collect(Collectors.toList());
    }

    public FeatureOutputDto getFeature(Integer id) {
        Feature feature = featureRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(String.format("Feature with id %d not found", id))
        );
        return featureDtoService.toDto(feature);
    }

    public void saveFeature(FeatureInputDto featureDto)  {
        featureRepository.save(featureDtoService.toEntity(featureDto));
    }
}
