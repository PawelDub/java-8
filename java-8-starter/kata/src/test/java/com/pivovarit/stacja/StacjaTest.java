package com.pivovarit.stacja;

import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class StacjaTest {

    @Test
    void ex_1() {
        Function<String, String> foo = s -> {
            return s.toLowerCase();
        };

        Function<String, String> foo2 = s -> s.toUpperCase();

        System.out.println(foo.apply("ASD"));

        Function<String, String> foo3 = foo.andThen(foo2);

        System.out.println(foo3.apply("asd2"));
    }

    @Test
    void ex_2() {

        Consumer<Integer> consumer1 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };

        consumer1.accept(42);
    }

    @Test
    void ex_3() {
        Supplier<Integer> predicate = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return 42;
        };

        //System.out.println(predicate.get());
    }

    @Test
    void ex_4() {
        BinaryOperator<String> binary = (s, s2) -> s + s2;

        System.out.println(binary.apply("ab", "cd"));
    }

    @Test
    void ex_5() {
        IntSupplier intSupplier = () -> 42;
    }
}
