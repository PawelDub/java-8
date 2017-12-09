package com.pivovarit.stacja;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class StacjaStreamTest {

    @Test
    void ex_1() {
        Arrays.asList(1, 2, 3).stream()
          .map(i -> i + 1)
          .forEach(System.out::println);
    }

    @Test
    void ex_2() {
        Arrays.asList(1, 2, 3).stream()
          .filter(i -> i % 2 == 0)
          .map(i -> i + 1)
          .forEach(System.out::println);
    }

    @Test
    void ex_3() {
        Arrays.asList(1, 2, 3).stream()
          .limit(712638712)
          .forEach(System.out::println);
    }

    @Test
    void ex_4() {
        Arrays.asList(1, 2, 3).stream()
          .limit(2)
          .forEach(System.out::println);
    }

    @Test
    void ex_5() {
        Integer any = Arrays.asList(1, 2, 3).stream()
          .limit(2)
          .map(i -> i * 20)
          .findAny()
          .orElseThrow(IllegalArgumentException::new);

        System.out.println(any);
    }

    @Test
    void ex_6() {
        Arrays.asList(1, 2, 3).stream()
          .limit(2)
          .map(i -> {
              System.out.println(i);
              return null;
          });
    }
}
