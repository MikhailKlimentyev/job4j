package ru.job4j.sorting;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int minLength;
        int lengthСomparison;
        if (left.length() == right.length()) {
            minLength = left.length();
            lengthСomparison = 0;
        } else if (left.length() < right.length()) {
            minLength = left.length();
            lengthСomparison = -1;
        } else {
            minLength = right.length();
            lengthСomparison = 1;
        }
        for (int index = 0; index != minLength; index++) {
            int symbolСomparison = Character.compare(left.charAt(index), right.charAt(index));
            if (symbolСomparison != 0) {
                return symbolСomparison;
            }
        }
        return lengthСomparison;
    }
}


