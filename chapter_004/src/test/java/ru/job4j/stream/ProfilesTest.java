package ru.job4j.stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;


/**
 * The type Profiles test.
 */
public class ProfilesTest {
    /**
     * T.
     */
    @Test
    public void whenProfilesThenAddresses() {
        Profiles profiles = new Profiles();
        Address vitebsk = new Address("Vitebsk");
        Address minsk = new Address("Minsk");
        Address liverpool = new Address("Liverpool");
        Address milan = new Address("Milan");
        List<Profile> profileList = Arrays.asList(
            new Profile(vitebsk),
            new Profile(minsk),
            new Profile(liverpool),
            new Profile(milan)
        );
        List<Address> addresses = profiles.collect(profileList);
        List<Address> expectedAddresses = Arrays.asList(vitebsk, minsk, liverpool, milan);
        assertThat(addresses, is(expectedAddresses));
    }

    /**
     * T.
     */
    @Test
    public void whenProfilesThenUniqueAddresses() {
        Address firstVitebsk = new Address("Vitebsk", "3434", 4, 4);
        Address secondVitebsk = new Address("Vitebsk", "3434", 4, 4);
        Address minsk = new Address("Minsk", "ddd", 5, 6);
        Address firstLiverpool = new Address("Liverpool", "fhrfhr", 55, 566);
        Address secondLiverpool = new Address("Liverpool", "fhrfhr", 55, 566);
        Address milan = new Address("Milan", "eheh", 44, 44);
        List<Profile> profileList = Arrays.asList(
            new Profile(firstVitebsk),
            new Profile(secondVitebsk),
            new Profile(minsk),
            new Profile(firstLiverpool),
            new Profile(secondLiverpool),
            new Profile(milan)
        );
        Profiles profiles = new Profiles();
        List<Address> addresses = profiles.collectUniqueAddresses(profileList);
        List<Address> expectedAddresses = Arrays.asList(firstLiverpool, milan, minsk, firstVitebsk);
        assertThat(addresses, is(expectedAddresses));
    }
}
