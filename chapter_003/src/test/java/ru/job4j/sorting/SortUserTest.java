package ru.job4j.sorting;

import static org.junit.Assert.assertThat;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class SortUserTest {

    @Test
    public void testWhenUserHasLessAgeThenUserPlacedEarlier() {
        SortUser sortUser = new SortUser();

        User alex = new User("Alex", 33);
        User ivan = new User("Ivan", 65);
        User roman = new User("Roman", 32);

        Set<User> actual = sortUser.sort(Arrays.asList(alex, ivan, roman));
        assertThat(actual, IsIterableContainingInOrder.contains(roman, alex, ivan));
    }

    @Test
    public void testWhenUserHasShorterNameThenUserPlacedEarlier() {
        SortUser sortUser = new SortUser();

        User alex = new User("Alex", 33);
        User ivan = new User("Ivan", 65);
        User roman = new User("Roman", 32);

        List<User> actual = sortUser.sortNameLength((Arrays.asList(alex, ivan, roman)));
        assertThat(actual, IsIterableContainingInOrder.contains(alex, ivan, roman));
    }

    @Test
    public void testWhenUserHasNameAndAgeThenSortByNameLexicographicallyAndThenSortByAge() {
        SortUser sortUser = new SortUser();

        User sergey25 = new User("Sergey", 25);
        User ivan30 = new User("Ivan", 30);
        User sergey20 = new User("Sergey", 20);
        User ivan25 = new User("Ivan", 25);

        List<User> actual = sortUser.sortByAllFields((Arrays.asList(sergey25, ivan30, sergey20, ivan25)));
        assertThat(actual, IsIterableContainingInOrder.contains(ivan25, ivan30, sergey20, sergey25));
    }
}
