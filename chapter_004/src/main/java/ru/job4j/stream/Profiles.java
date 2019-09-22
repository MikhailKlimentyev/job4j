package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Profiles.
 */
public class Profiles {
    /**
     * Collect list.
     *
     * @param profiles the profiles
     * @return the list
     */
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
            .map(profile -> profile.getAddress())
            .collect(Collectors.toList());
    }

    /**
     * Collect unique addresses list.
     *
     * @param profiles the profiles
     * @return the list
     */
    public List<Address> collectUniqueAddresses(List<Profile> profiles) {
        return profiles.stream()
            .map(Profile::getAddress)
            .sorted(Comparator.comparing(Address::getCity))
            .distinct()
            .collect(Collectors.toList());
    }
}
