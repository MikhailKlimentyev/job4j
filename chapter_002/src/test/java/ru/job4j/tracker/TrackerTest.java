package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * TrackerTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/25/2018
 */
public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("testName", "testDescription");
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnTrueAndNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("testName1", "testDescription1");
        tracker.add(previous);
        Item next = new Item("testName2", "testDescription2");
        next.setId(previous.getId());
        assertTrue(tracker.replace(previous.getId(), next));
        assertThat(tracker.findAll()[0].getName(), is("testName2"));
    }

    @Test
    public void whenDoNotReplaceNameThenReturnFalse() {
        Tracker tracker = new Tracker();
        Item previous = new Item("testName1", "testDescription1");
        tracker.add(previous);
        Item next = new Item("testName2", "testDescription2");
        next.setId(previous.getId());
        assertFalse(tracker.replace("12516271271383", next));
    }

    @Test
    public void whenDeleteItemFromBeginThenTrueAndShiftItemsFromEnd() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testName1", "testDescription1");
        Item item2 = new Item("testName2", "testDescription2");
        Item item3 = new Item("testName3", "testDescription3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertTrue(tracker.delete(item1.getId()));
        assertThat(tracker.findAll().length, is(2));
        assertThat(tracker.findAll()[0], is(item2));
        assertThat(tracker.findAll()[1], is(item3));
    }

    @Test
    public void whenDeleteItemFromMiddleThenTrueAndShiftItemsFromEnd() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testName1", "testDescription1");
        Item item2 = new Item("testName2", "testDescription2");
        Item item3 = new Item("testName3", "testDescription3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertTrue(tracker.delete(item2.getId()));
        assertThat(tracker.findAll().length, is(2));
        assertThat(tracker.findAll()[0], is(item1));
        assertThat(tracker.findAll()[1], is(item3));
    }

    @Test
    public void whenDeleteItemFromEndThenTrueAndShiftItemsFromBegin() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testName1", "testDescription1");
        Item item2 = new Item("testName2", "testDescription2");
        Item item3 = new Item("testName3", "testDescription3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertTrue(tracker.delete(item3.getId()));
        assertThat(tracker.findAll().length, is(2));
        assertThat(tracker.findAll()[0], is(item1));
        assertThat(tracker.findAll()[1], is(item2));
    }

    @Test
    public void whenDoNotDeleteItemFromArrayThenFalse() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testName1", "testDescription1");
        Item item2 = new Item("testName2", "testDescription2");
        Item item3 = new Item("testName3", "testDescription3");
        Item item4 = new Item("testName4", "testDescription4");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertFalse(tracker.delete(item4.getId()));
    }

    @Test
    public void whenFindAllThenArrayOfItemsReturned() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testName1", "testDescription1");
        Item item2 = new Item("testName2", "testDescription2");
        Item item3 = new Item("testName3", "testDescription3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findAll().length, is(3));
        assertThat(tracker.findAll()[0], is(item1));
        assertThat(tracker.findAll()[1], is(item2));
        assertThat(tracker.findAll()[2], is(item3));
    }

    @Test
    public void whenFindByNameThenArrayOfItemsReturned() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testName1", "testDescription1");
        Item item2 = new Item("testName2", "testDescription2");
        Item item3 = new Item("testName3", "testDescription3");
        tracker.add(item1);
        tracker.add(item1);
        tracker.add(item3);
        assertThat(tracker.findByName("testName1").length, is(3));
        assertThat(tracker.findByName("testName1")[0], is(item1));
        assertThat(tracker.findByName("testName1")[1], is(item1));
        assertThat(tracker.findByName("testName1")[2], is(nullValue()));
    }

    @Test
    public void whenFindByIdThenItemIfExists() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testName1", "testDescription1");
        Item item2 = new Item("testName2", "testDescription2");
        Item item3 = new Item("testName3", "testDescription3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        String expected = tracker.findAll()[1].getId();
        assertThat(tracker.findById(expected), is(item2));
    }

    @Test
    public void whenFindByIdThenItemIfNotExists() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testName1", "testDescription1");
        Item item2 = new Item("testName2", "testDescription2");
        Item item3 = new Item("testName3", "testDescription3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findById("64754594959445"), is(nullValue()));
    }
}