package com.example.featureflag.domain;

import java.util.Arrays;

public enum Accessibility {
    GLOBAL, PERSONAL, GROUP;

    public static Accessibility of (String type) {
        return Arrays.stream(Accessibility.values())
                .filter(value -> value.name().equalsIgnoreCase(type))
                .findAny().orElseThrow(() -> new IllegalArgumentException(
                        String.format("Wrong accessibility type: " + type)));
    }
}
