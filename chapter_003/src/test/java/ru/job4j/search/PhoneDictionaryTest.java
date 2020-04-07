package ru.job4j.search;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * The type Phone dictionary test.
 */
public class PhoneDictionaryTest {
    /**
     * T.
     */
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        var persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    /**
     * T.
     */
    @Test
    public void whenFindBySurname() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        var persons = phones.find("sen");
        assertThat(persons.iterator().next().getName(), is("Petr"));
    }

    /**
     * T.
     */
    @Test
    public void whenFindByPhone() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        var persons = phones.find("2");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    /**
     * T.
     */
    @Test
    public void whenFindByAddress() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        var persons = phones.find("Br");
        assertThat(persons.iterator().next().getPhone(), is("534872"));
    }
}
