package com.pivovarit.stacja;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class StacjaOptionalTest {

    @Test
    void ex_1() {
        Optional<Integer> o = findOptionalById(42);
        System.out.println(o);

        Optional<Integer> o2 = findOptionalById(43);
        System.out.println(o2);
    }

    public Integer findById(Integer i) {
        if (i % 2 == 1) {
            return null;
        } else {
            return i;
        }
    }

    public Optional<Integer> findOptionalById(Integer i) {
        if (i % 2 == 1) {
            return Optional.empty();
        } else {
            return Optional.of(i);
        }
    }

    public Optional<Integer> findOptionalByIdDelegate(Integer i) {
        return Optional.ofNullable(findById(i));
    }
}
