package ru.job4j.search;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserConvertTest {

    @Test
    public void testWhenListOfUsersThenMapOfIntegerAndUsers() {
        UserConvert userConvert = new UserConvert();
        User ivan = new User(466456465, "Ivan", "Manchester");
        User petr = new User(13, "Petr", "Minsk");
        User mikhail = new User(666, "Mikhail", "Riga");
        List<User> users = Arrays.asList(ivan, petr, mikhail);

        Map<Integer, User> actualUsersMap = userConvert.process(users);
        Map<Integer, User> expectedUsersMap = new HashMap<>();

        expectedUsersMap.put(ivan.getId(), ivan);
        expectedUsersMap.put(petr.getId(), petr);
        expectedUsersMap.put(mikhail.getId(), mikhail);

        assertThat(actualUsersMap, is(expectedUsersMap));
    }

    @Test
    public void testWhenListOfUsersIncludesUserWithNullFieldThenMapOfIntegerAndUsers() {
        UserConvert userConvert = new UserConvert();
        User ivan = new User(0, null, null);
        User petr = new User(13, "Petr", "Minsk");
        List<User> users = Arrays.asList(ivan, petr);

        Map<Integer, User> actualUsersMap = userConvert.process(users);
        Map<Integer, User> expectedUsersMap = new HashMap<>();

        expectedUsersMap.put(ivan.getId(), ivan);
        expectedUsersMap.put(petr.getId(), petr);

        assertThat(actualUsersMap, is(expectedUsersMap));
    }
}
