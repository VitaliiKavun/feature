package com.example.featureflag.controller;

import com.example.featureflag.domain.dto.feature.FeatureInputDto;
import com.example.featureflag.domain.dto.feature.FeatureOutputDto;
import com.example.featureflag.service.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feature")
public class FeatureController {

    private final FeatureService featureService;

    @GetMapping
    public ResponseEntity getFeatures() {
        return ResponseEntity.ok(featureService.getFeatures());
    }

    @GetMapping("/{id}")
    public ResponseEntity getFeature(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(featureService.getFeature(id));
    }

    @PostMapping
    public ResponseEntity saveFeature(@RequestBody FeatureInputDto featureDto) {
        featureService.saveFeature(featureDto);
        return ResponseEntity.ok().build();
    }


}
