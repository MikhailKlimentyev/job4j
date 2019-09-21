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
}
