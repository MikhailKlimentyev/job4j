package ru.job4j.search;

import java.util.HashMap;
import java.util.List;

public class UserConvert {

    public HashMap<Integer, User> process(List<User> users) {
        HashMap<Integer, User> usersMap = new HashMap<>();
        for (User user : users) {
            usersMap.put(user.getId(), user);
        }
        return usersMap;
    }
}
