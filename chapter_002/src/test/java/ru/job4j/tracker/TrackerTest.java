package ru.job4j.tracker;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
        assertThat(tracker.findAll().get(0), is(item));
    }

    @Test
    public void whenReplaceNameThenReturnTrueAndNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("testName1", "testDescription1");
        tracker.add(previous);
        Item next = new Item("testName2", "testDescription2");
        next.setId(previous.getId());
        assertTrue(tracker.replace(previous.getId(), next));
        assertThat(tracker.findAll().get(0).getName(), is("testName2"));
    }

    @Test
    public void whenReplaceDescriptionThenReturnNewDescription() {
        Tracker tracker = new Tracker();
        Item previous = new Item("testName1", "testDescription1");
        tracker.add(previous);
        Item next = new Item("testName2", "testDescription2");
        next.setId(previous.getId());
        assertTrue(tracker.replace(previous.getId(), next));
        assertThat(tracker.findAll().get(0).getDesc(), is("testDescription2"));
    }

    @Test
    public void whenReplaceItemThenReturnOriginalId() {
        Tracker tracker = new Tracker();
        Item previous = new Item("testName1", "testDescription1");
        tracker.add(previous);
        Item next = new Item("testName2", "testDescription2");
        next.setId(previous.getId());
        assertTrue(tracker.replace(previous.getId(), next));
        assertThat(tracker.findAll().get(0).getId(), is(previous.getId()));
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
        assertThat(tracker.findAll().size(), is(2));
        assertThat(tracker.findAll().get(0), is(item2));
        assertThat(tracker.findAll().get(1), is(item3));
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
        assertThat(tracker.findAll().size(), is(2));
        assertThat(tracker.findAll().get(0), is(item1));
        assertThat(tracker.findAll().get(1), is(item3));
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
        assertThat(tracker.findAll().size(), is(2));
        assertThat(tracker.findAll().get(0), is(item1));
        assertThat(tracker.findAll().get(1), is(item2));
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
        assertThat(tracker.findAll().size(), is(3));
        assertThat(tracker.findAll().get(0), is(item1));
        assertThat(tracker.findAll().get(1), is(item2));
        assertThat(tracker.findAll().get(2), is(item3));
    }

    @Test
    public void whenFindByNameThenListOfItemsReturned() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testName1", "testDescription1");
        Item item2 = new Item("testName2", "testDescription2");
        Item item3 = new Item("testName3", "testDescription3");
        tracker.add(item1);
        tracker.add(item1);
        tracker.add(item3);
        assertThat(tracker.findByName("testName1").size(), is(2));
        assertThat(tracker.findByName("testName1").get(0), is(item1));
        assertThat(tracker.findByName("testName1").get(1), is(item1));
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
        String expected = tracker.findAll().get(1).getId();
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