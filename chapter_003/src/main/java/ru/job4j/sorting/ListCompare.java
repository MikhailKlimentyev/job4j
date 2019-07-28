package ru.job4j.sorting;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int minLength;
        int lengthComparison;
        if (left.length() == right.length()) {
            minLength = left.length();
            lengthComparison = 0;
        } else if (left.length() < right.length()) {
            minLength = left.length();
            lengthComparison = -1;
        } else {
            minLength = right.length();
            lengthComparison = 1;
        }
        for (int index = 0; index != minLength; index++) {
            int symbolComparison = Character.compare(left.charAt(index), right.charAt(index));
            if (symbolComparison != 0) {
                return symbolComparison;
            }
        }
        return lengthComparison;
    }
}


