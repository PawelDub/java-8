package com.pivovarit.stacja;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class StacjaStreamTest {

    @Test
    void ex_1() {
        asList(1, 2, 3).stream()
          .map(i -> i + 1)
          .forEach(System.out::println);
    }

    @Test
    void ex_2() {
        asList(1, 2, 3).stream()
          .filter(i -> i % 2 == 0)
          .map(i -> i + 1)
          .forEach(System.out::println);
    }

    @Test
    void ex_3() {
        asList(1, 2, 3).stream()
          .limit(712638712)
          .forEach(System.out::println);
    }

    @Test
    void ex_4() {
        asList(1, 2, 3).stream()
          .limit(2)
          .forEach(System.out::println);
    }

    @Test
    void ex_5() {
        Integer any = asList(1, 2, 3).stream()
          .limit(2)
          .map(i -> i * 20)
          .findAny()
          .orElseThrow(IllegalArgumentException::new);

        System.out.println(any);
    }

    @Test
    void ex_6() {
        asList(1, 2, 3).stream()
          .limit(2)
          .map(i -> {
              System.out.println(i);
              return null;
          });
    }

    @Test
    void ex_7() {
        asList(1, 2, 3).stream()
          .limit(2)
          .map(i -> {
              System.out.println(i);
              return null;
          })
          .forEach(System.out::println);
    }

    @Test
    void ex_8() {
        asList(
          asList(1, 2, 3),
          asList(4, 5, 6),
          asList(7, 8, 9)).stream()
          .forEach(System.out::println);
    }

    @Test
    void ex_9() {
        asList(
          asList(1, 2, 3),
          asList(4, 5, 6),
          asList(7, 8, 9)).stream()
          .flatMap(i -> i.stream())
          .forEach(System.out::println);
    }

    @Test
    void ex_10() {
        asList(
          asList(1, 2, 3),
          asList(4, 5, 6),
          asList(7, 8, 9)).stream()
          .flatMap(i -> i.stream())
          .forEach(System.out::println);
    }

    @Test
    void ex_12() {
        asList(
          asList(1, 2, 3),
          asList(4, 5, 6),
          asList(7, 8, 9)).stream()
          .flatMap(i -> i.stream())
          .findAny();
    }

    @Test
    void ex_13() {
        Stream.of(IntStream.generate(() -> 42).boxed())
          .flatMap(i -> i)
          .findAny();
    }

    //git clone https://pivovarit@bitbucket.org/pivovarit/java8-kata.git

    @Test
    void ex_11() {
        Customer adam = new Customer(Arrays.asList(
          new Order("cookies"),
          new Order("beer")
        ));

        Customer ewa = new Customer(Arrays.asList(
          new Order("ribs")
        ));

        Arrays.asList(adam, ewa).stream()
          .flatMap(c -> c.getOrders().stream())
          .forEach(System.out::println);
    }
}
