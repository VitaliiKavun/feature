package com.example.featureflag.repository;

import com.example.featureflag.domain.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Integer> {
}
