package com.pivovarit.stacja;

import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.Lazy;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.stream.Collectors;

public class VavrTest {

    @Test
    void ex_1() {
        Function2<Integer, Integer, Integer> foo = (integer, integer2) -> integer + integer2;
        foo.memoized();
        Function1<Integer, Function1<Integer, Integer>> curried = foo.curried();

        Function1<Integer, Integer> apply = curried.apply(2);
    }

    @Test
    void ex_2() {
        List<Integer> list1 = List.of(42);
        List<Integer> list2 = list1.append(13);
        System.out.println(list1);
        System.out.println(list2);
    }

    @Test
    void ex_3() {
        List.of(42)
          .collect(Collectors.toList());
    }

    @Test
    void ex_4() {
        System.out.println(List.of(Option.of(42), Option.of(24))
          .flatMap(i -> i));
    }

    @Test
    void ex_5() {
        String aDefault = Try.of(() -> new URL("  ./asd./#"))
          .map(url -> url.toString())
          .filter(i -> true)
          .recover(IllegalArgumentException.class, e -> ":D")
          .getOrElse("default");

        System.out.println(aDefault);
    }

    @Test
    void ex_6() {
        String aDefault = Try.of(() -> new URL("http://www.google.com"))
          .map(url -> url.toString())
          .filter(i -> true)
          .recover(IllegalArgumentException.class, e -> ":D")
          .getOrElse("default");

        System.out.println(aDefault);
    }

    @Test
    void ex_7() {
        String aDefault = Try.of(() -> Integer.parseInt(".as,d.as,"))
          .map(s -> s.toString())
          .recover(NumberFormatException.class, e -> "pusty")
          .getOrElse("default");

        System.out.println(aDefault);
    }

    @Test
    void ex_8() {
        Lazy.of(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
            }
            return "42";
        })
          .map(s -> s + "42242");
    }

    @Test
    void ex_9() {
        Lazy.of(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
            }
            return "42";
        })
          .map(s -> s + "42242")
          .get();
    }

    @Test
    void ex_10() {
        List.of(24)
          .toJavaList();

        List.of(24)
          .asJava();
    }


    @Test
    void ex_11() {
        Either.left(42)
          .left()
          .forEach(System.out::println);
    }

    @Test
    void ex_12() {
        Either.left(42)
          .right()
          .forEach(System.out::println);
    }
}
