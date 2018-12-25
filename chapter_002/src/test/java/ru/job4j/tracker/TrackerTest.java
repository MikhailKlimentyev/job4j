package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

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
        Item item = new Item("testName", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("testName1", "testDescription1", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("testName2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("testName2"));
    }

    @Test
    public void whenDeleteItemFromBeginThenShiftItemsFromEnd() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testName1", "testDescription1", 123L);
        Item item2 = new Item("testName2", "testDescription2", 1234L);
        Item item3 = new Item("testName3", "testDescription3", 12345L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item1.getId());
        assertThat(tracker.findAll()[0], is(item2));
        assertThat(tracker.findAll()[1], is(item3));
        assertThat(tracker.findAll()[2], is(item3));
    }

    @Test
    public void whenDeleteItemFromMiddleThenShiftItemsFromEnd() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testName1", "testDescription1", 123L);
        Item item2 = new Item("testName2", "testDescription2", 1234L);
        Item item3 = new Item("testName3", "testDescription3", 12345L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item2.getId());
        assertThat(tracker.findAll()[0], is(item1));
        assertThat(tracker.findAll()[1], is(item3));
        assertThat(tracker.findAll()[2], is(item3));
    }

    @Test
    public void whenDeleteItemFromEndThenShiftItemsFromBegin() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testName1", "testDescription1", 123L);
        Item item2 = new Item("testName2", "testDescription2", 1234L);
        Item item3 = new Item("testName3", "testDescription3", 12345L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item3.getId());
        assertThat(tracker.findAll()[0], is(item1));
        assertThat(tracker.findAll()[1], is(item2));
        assertThat(tracker.findAll()[2], is(item1));
    }

    @Test
    public void whenFindAllThenArrayOfItemsReturned() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testName1", "testDescription1", 123L);
        Item item2 = new Item("testName2", "testDescription2", 1234L);
        Item item3 = new Item("testName3", "testDescription3", 12345L);
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
        Item item1 = new Item("testName1", "testDescription1", 123L);
        Item item2 = new Item("testName2", "testDescription2", 1234L);
        Item item3 = new Item("testName3", "testDescription3", 12345L);
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
        Item item1 = new Item("testName1", "testDescription1", 123L);
        Item item2 = new Item("testName2", "testDescription2", 1234L);
        Item item3 = new Item("testName3", "testDescription3", 12345L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        String expected = tracker.findAll()[1].getId();
        assertThat(tracker.findById(expected), is(item2));
    }

    @Test
    public void whenFindByIdThenItemIfNotExists() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testName1", "testDescription1", 123L);
        Item item2 = new Item("testName2", "testDescription2", 1234L);
        Item item3 = new Item("testName3", "testDescription3", 12345L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findById("64754594959445"), is(nullValue()));
    }
}
