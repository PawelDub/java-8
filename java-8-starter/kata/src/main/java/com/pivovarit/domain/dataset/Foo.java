package com.pivovarit.domain.dataset;

import com.pivovarit.domain.domain.Mall;

import java.util.stream.Stream;

public class Foo {
    public Mall getMall() {
        return Stream.<Mall>of().findFirst().orElse(null);
    }
}
