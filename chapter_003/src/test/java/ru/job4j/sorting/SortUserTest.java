package ru.job4j.sorting;

import static org.junit.Assert.assertThat;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import java.util.Arrays;
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
}
