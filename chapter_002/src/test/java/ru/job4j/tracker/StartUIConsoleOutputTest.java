package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * StartUIConsoleOutputTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 01/01/2019
 */
public class StartUIConsoleOutputTest {

    /**
     * Поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream out = System.out;

    /**
     * Буфер для результата.
     */
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();

    /**
     * Текст меню, которое выводится на консоль.
     */
    private final String menu = "Menu:"
        + System.lineSeparator()
        + "0. Add new item"
        + System.lineSeparator()
        + "1. Show all items"
        + System.lineSeparator()
        + "2. Edit item"
        + System.lineSeparator()
        + "3. Delete item"
        + System.lineSeparator()
        + "4. Find item by Id"
        + System.lineSeparator()
        + "5. Find items by name"
        + System.lineSeparator()
        + "6. Exit Program";

    private final String stop =
        "------------ Program has been stopped ------------------"
            + System.lineSeparator();

    /**
     * Метод устанавливает вывод в память.
     */
    @Before
    public void loadOutput() {
        System.out.println("Execute before method.");
        System.setOut(new PrintStream(this.mem));
    }

    /**
     * Метод устанавливает вывод в консоль.
     */
    @After
    public void backOutput() {
        System.setOut(this.out);
        System.out.println("Execute after method.");
    }

    //createItem() test
    @Test
    public void whenCreateItemThenIdOfCreatedItemPrintedInConsole() {
        Tracker tracker = new Tracker();
        new StartUI(new StubInput(Arrays.asList("0", "test name", "desc", "6")), tracker).init();
        assertThat(
            new String(mem.toByteArray()),
            is(
                new StringBuilder()
                    .append(menu)
                    .append(System.lineSeparator())
                    .append("------------ Adding of a new item --------------")
                    .append(System.lineSeparator())
                    .append("------------ New item with Id: " + tracker
                        .findAll()
                        .get(0)
                        .getId() + " is created -----------")
                    .append(System.lineSeparator())
                    .append(menu)
                    .append(System.lineSeparator())
                    .append(stop)
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
        new StartUI(new StubInput(Arrays.asList("1", "6")), tracker).init();
        assertThat(
            new String(mem.toByteArray()),
            is(
                new StringBuilder()
                    .append(menu)
                    .append(System.lineSeparator())
                    .append("------------ All items: --------------")
                    .append(System.lineSeparator())
                    .append("0. " + tracker.findAll().get(0).toString())
                    .append(System.lineSeparator())
                    .append("1. " + tracker.findAll().get(1).toString())
                    .append(System.lineSeparator())
                    .append("2. " + tracker.findAll().get(2).toString())
                    .append(System.lineSeparator())
                    .append("---------------------------------------")
                    .append(System.lineSeparator())
                    .append(menu)
                    .append(System.lineSeparator())
                    .append(stop)
                    .toString()
            )
        );
    }

    //editItem() test
    @Test
    public void whenEditItemThenIdOfUpdatedItemPrintedInConsole() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        String initialId = tracker.findAll().get(0).getId();
        new StartUI(new StubInput(Arrays.asList("2", "replaced name", "replaced desc", item.getId(), "6")),
            tracker).init();
        assertThat(
            new String(mem.toByteArray()),
            is(
                new StringBuilder()
                    .append(menu)
                    .append(System.lineSeparator())
                    .append("------------ Item with Id: " + initialId + " was successfully replaced -----------")
                    .append(System.lineSeparator())
                    .append(menu)
                    .append(System.lineSeparator())
                    .append(stop)
                    .toString()
            )
        );
    }

    //deleteItem() test
    @Test
    public void whenEditItemThenIdOfDeletedItemPrintedInConsole() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        new StartUI(new StubInput(Arrays.asList("3", item.getId(), "6")), tracker).init();
        assertThat(
            new String(mem.toByteArray()),
            is(
                new StringBuilder()
                    .append(menu)
                    .append(System.lineSeparator())
                    .append("------------ Item with Id: " + item.getId() + " was successfully deleted -----------")
                    .append(System.lineSeparator())
                    .append(menu)
                    .append(System.lineSeparator())
                    .append(stop)
                    .toString()
            )
        );
    }

    //findItemById() test
    @Test
    public void whenFindItemByIdThenDeletedItemPrintedInConsole() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        new StartUI(new StubInput(Arrays.asList("4", item.getId(), "6")), tracker).init();
        assertThat(
            new String(mem.toByteArray()),
            is(
                new StringBuilder()
                    .append(menu)
                    .append(System.lineSeparator())
                    .append(tracker.findById(item.getId()).toString())
                    .append(System.lineSeparator())
                    .append("---------------------------------------")
                    .append(System.lineSeparator())
                    .append(menu)
                    .append(System.lineSeparator())
                    .append(stop)
                    .toString()
            )
        );
    }

    //findItemByName() tests
    @Test
    public void whenFindItemByNameThenDeletedItemPrintedInConsole() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        new StartUI(new StubInput(Arrays.asList("5", item.getName(), "6")), tracker).init();
        assertThat(
            new String(mem.toByteArray()),
            is(
                new StringBuilder()
                    .append(menu)
                    .append(System.lineSeparator())
                    .append(tracker.findById(item.getId()).toString())
                    .append(System.lineSeparator())
                    .append("---------------------------------------")
                    .append(System.lineSeparator())
                    .append(menu)
                    .append(System.lineSeparator())
                    .append(stop)
                    .toString()
            )
        );
    }
}