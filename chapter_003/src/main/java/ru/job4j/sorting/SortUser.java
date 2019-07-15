package ru.job4j.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {

    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    public List<User> sortNameLength(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User firstUser, User secondUser) {
                return firstUser.getName().length() - secondUser.getName().length();
            }
        });
        return users;
    }

    public List<User> sortByAllFields(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User firstUser, User secondUser) {
                int comparison;
                comparison = firstUser.getName().compareTo(secondUser.getName());
                if (comparison == 0) {
                    comparison = firstUser.getAge().compareTo(secondUser.getAge());
                }
                return comparison;
            }
        });
        return users;
    }
}
