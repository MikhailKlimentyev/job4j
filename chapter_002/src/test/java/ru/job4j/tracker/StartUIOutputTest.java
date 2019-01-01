package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * StartUIOutputTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 01/01/2019
 */
public class StartUIOutputTest {

    /**
     * Поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream stdOut = System.out;

    /**
     * Буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("Execute before method.");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdOut);
        System.out.println("Execute after method.");
    }

    //createItem() test
    @Test
    public void whenCreateItemThenIdOfCreatedItemPrintedInConsole() {
        Tracker tracker = new Tracker();
        new StartUI(new StubInput(new String[]{"0", "test name", "desc", "6"}), tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(System.lineSeparator())
                                .append("Menu:")
                                .append(System.lineSeparator())
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .append("------------ Adding of a new item --------------")
                                .append(System.lineSeparator())
                                .append("------------ New item with Id: " + tracker.findAll()[0].getId() + " is created -----------")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append("Menu:")
                                .append(System.lineSeparator())
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    //showAllItems() test
    @Test
    public void whenShowAllItemsThenAllItemsPrintedInConsole() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        new StartUI(new StubInput(new String[]{"1", "6"}), tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(System.lineSeparator())
                                .append("Menu:")
                                .append(System.lineSeparator())
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .append("------------ All items: --------------")
                                .append(System.lineSeparator())
                                .append("0. " + tracker.findAll()[0].toString())
                                .append(System.lineSeparator())
                                .append("1. " + tracker.findAll()[1].toString())
                                .append(System.lineSeparator())
                                .append("2. " + tracker.findAll()[2].toString())
                                .append(System.lineSeparator())
                                .append("---------------------------------------")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append("Menu:")
                                .append(System.lineSeparator())
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    //editItem() test
    @Test
    public void whenEditItemThenIdOfUpdatedItemPrintedInConsole() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        String initialId = tracker.findAll()[0].getId();
        new StartUI(new StubInput(new String[]{"2", "replaced name", "replaced desc", item.getId(), "6"}), tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(System.lineSeparator())
                                .append("Menu:")
                                .append(System.lineSeparator())
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .append("------------ Item with Id: " + initialId + " was successfully replaced -----------")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append("Menu:")
                                .append(System.lineSeparator())
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    //deleteItem() test
    @Test
    public void whenEditItemThenIdOfDeletedItemPrintedInConsole() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        new StartUI(new StubInput(new String[]{"3", item.getId(), "6"}), tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(System.lineSeparator())
                                .append("Menu:")
                                .append(System.lineSeparator())
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .append("------------ Item with Id: " + item.getId() + " was successfully deleted -----------")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append("Menu:")
                                .append(System.lineSeparator())
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    //findItemById() test
    @Test
    public void whenFindItemByIdThenDeletedItemPrintedInConsole() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        new StartUI(new StubInput(new String[]{"4", item.getId(), "6"}), tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(System.lineSeparator())
                                .append("Menu:")
                                .append(System.lineSeparator())
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .append(tracker.findById(item.getId()).toString())
                                .append(System.lineSeparator())
                                .append("---------------------------------------")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append("Menu:")
                                .append(System.lineSeparator())
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    //findItemByName() tests
    @Test
    public void whenFindItemByNameThenDeletedItemPrintedInConsole() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        new StartUI(new StubInput(new String[]{"5", item.getName(), "6"}), tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(System.lineSeparator())
                                .append("Menu:")
                                .append(System.lineSeparator())
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .append(tracker.findById(item.getId()).toString())
                                .append(System.lineSeparator())
                                .append("---------------------------------------")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append("Menu:")
                                .append(System.lineSeparator())
                                .append("0. Add new item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}