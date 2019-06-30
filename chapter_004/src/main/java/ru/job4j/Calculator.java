package ru.job4j;

import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * 0. Функциональные итерфейсы.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 03/06/2019
 */
public class Calculator {

//    public interface Operation {
//        double calc(int left, int right);
//    }

    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.multiple(
                0, 10, 2,
                //public interface BiFunction<T, U, R> {
                //	R apply(T t, U u);
                //}
                //BiFunction<Integer, Integer, Double> op
                (value, index) -> {
                    double result = value * index;
                    System.out.printf("Multiple %s * %s = %s %n", value, index, result);
                    return result;
                },
                //public interface Consumer<T> {
                //	void accept(T t);
                //}
                //Consumer<Double> media
                result -> System.out.println(result)
        );
    }
}