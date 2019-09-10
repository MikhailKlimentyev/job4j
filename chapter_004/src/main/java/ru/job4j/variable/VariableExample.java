package ru.job4j.variable;

import java.util.Arrays;
import java.util.List;

public class VariableExample {

    List<String> names = Arrays.asList("Petr", "Nick", "Ban");
    String last = null;

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Petr", "Nick", "Ban");
        final StringBuilder last = new StringBuilder();
        names.forEach(
            n -> {
                last.ensureCapacity(0);
                last.append(n);
            }
        );
    }
}
