package com.pivovarit.stacja;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Function;

public class StacjaOptional2Test {

    @Test
    void ex_1() {
        Optional<Integer> o = findOptionalById(12);
        Optional<String> s = o.map(integer -> integer.toString());

        System.out.println(s);
    }

    @Test
    void ex_2() {
        Optional<String> s = findOptionalById(12)
          .map(integer -> integer.toString() + "string");

        System.out.println(s);
    }

    @Test
    void ex_3() {
        Optional<String> s = findOptionalById(12)
          .map(integer -> null);

        System.out.println(s);
    }

    @Test
    void ex_4() {
        findOptionalById(12)
          .map(integer -> integer * 2)
          .map(Object::toString);
          //.get();

    }

    @Test
    void ex_5() {
        String aDefault = findOptionalById(12)
          .map(integer -> integer * 2)
          .map(Object::toString)
          .orElse("default");

        System.out.println(aDefault);
    }

    @Test
    void ex_6() {
        String aDefault = findOptionalById(13)
          .map(integer -> integer * 2)
          .map(Object::toString)
          .orElse("default");

        System.out.println(aDefault);
    }

    @Test
    void ex_7() {
        String aDefault = findOptionalById(13)
          .map(integer -> integer * 2)
          .map(Object::toString)
          .orElseThrow(() -> new IllegalArgumentException());

        System.out.println(aDefault);
    }

    @Test
    void ex_8() {
        findOptionalById(13)
          .map(integer -> integer * 2)
          .map(Object::toString)
          .ifPresent(value -> System.out.println(value));

    }

    @Test
    void ex_9() {
        findOptionalById(12)
          .map(integer -> integer * 2)
          .map(Object::toString)
          .ifPresent(value -> System.out.println(value));
    }

    /**
     * NIE ROBIC TAK
     */
    @Test
    void ex_10() {
        /*Optional<Integer> id = findOptionalById(12);
        if (id.isPresent()) {
            System.out.println(id.get());
        } else {
            throw new IllegalArgumentException();
        }*/
    }

    @Test
    void ex_11() {
        findOptionalById(12)
          .map(integer -> integer * 2)
          .map(Object::toString)
          .filter(s -> !s.isEmpty())
          .ifPresent(value -> System.out.println(value));
    }

    @Test
    void ex_12() {
        findOptionalById(12)
          .map(integer -> integer * 2)
          .map(s -> "")
          .filter(s -> !s.isEmpty())
          .ifPresent(value -> System.out.println(value));
    }

    @Test
    void ex_13() {
        Integer i = findOptionalById(13)
          .orElse(calculateDefault());

        System.out.println(i);
    }

    @Test
    void ex_14() {
        Integer i = findOptionalById(12)
          .orElseGet(() -> calculateDefault());

        System.out.println(i);
    }

    private Integer calculateDefault() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
        }
        return 42;
    }

    public Optional<Integer> findOptionalById(Integer i) {
        return i % 2 == 1 ? Optional.empty() : Optional.of(i);
    }
}
