package ru.job4j.tracker;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Arrays;

/**
 * StartUILogicTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/30/2018
 */
public class StartUILogicTest {
    //createItem() test
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();

        Input input = new StubInput(Arrays.asList("0", "test name", "desc", "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    //showAllItems() tests
    @Test
    public void whenTrackerContainsSingleItemShowAllItemsThenSingleItemsReturned() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(Arrays.asList("1", "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().size(), is(1));
        assertThat(tracker.findAll().get(0), is(item));
    }

    @Test
    public void whenTrackerContainsSeveralItemsShowAllItemsThenAllItemsReturned() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(Arrays.asList("1", "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().size(), is(3));
        assertThat(tracker.findAll().get(0), is(firstItem));
        assertThat(tracker.findAll().get(1), is(secondItem));
        assertThat(tracker.findAll().get(2), is(thirdItem));
    }

    //editItem() tests
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(Arrays.asList("2", "replaced name", "replaced desc", item.getId(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("replaced name"));
        assertThat(tracker.findAll().get(0).getDesc(), is("replaced desc"));
    }

    @Test
    public void whenUpdateWithInvalidIdThenItemNotUpdated() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(Arrays.asList("2", "replaced name", "replaced desc", item.getId() + "0", "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0), is(item));
    }

    @Test
    public void whenTrackerContainsSeveralItemsUpdateFirstItemThenTrackerHasSameNumberOfItemsAndFirstItemUpdated() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(Arrays.asList("2", "replaced name", "replaced desc", firstItem.getId(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().size(), is(3));
        assertThat(tracker.findAll().get(0).getName(), is("replaced name"));
        assertThat(tracker.findAll().get(0).getDesc(), is("replaced desc"));
    }

    @Test
    public void whenTrackerContainsSeveralItemsUpdateLastItemThenTrackerHasSameNumberOfItemsAndLastItemUpdated() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(Arrays.asList("2", "replaced name", "replaced desc", thirdItem.getId(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().size(), is(3));
        assertThat(tracker.findAll().get(2).getName(), is("replaced name"));
        assertThat(tracker.findAll().get(2).getDesc(), is("replaced desc"));
    }

    @Test
    public void whenTrackerContainsSeveralItemsUpdateMiddleItemThenTrackerHasSameNumberOfItemsAndMiddleItemUpdated() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(Arrays.asList("2", "replaced name", "replaced desc", secondItem.getId(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().size(), is(3));
        assertThat(tracker.findAll().get(1).getName(), is("replaced name"));
    }

    //deleteItem() tests
    @Test
    public void whenDeleteThenItemDeleted() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(Arrays.asList("3", item.getId(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().size(), is(0));
    }

    @Test
    public void whenDeleteItemWithInvalidIdThenItemNotDeleted() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(Arrays.asList("3", "1" + item.getId(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().size(), is(1));
        assertThat(tracker.findAll().get(0), is(item));
    }

    @Test
    public void whenTrackerContainsSeveralItemsDeleteFirstItemThenFirstItemDeleted() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(Arrays.asList("3", firstItem.getId(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().size(), is(2));
        assertThat(tracker.findAll().get(0), is(secondItem));
        assertThat(tracker.findAll().get(1), is(thirdItem));
    }

    @Test
    public void whenTrackerContainsSeveralItemsDeleteLastItemThenLastItemDeleted() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(Arrays.asList("3", thirdItem.getId(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().size(), is(2));
        assertThat(tracker.findAll().get(0), is(firstItem));
        assertThat(tracker.findAll().get(1), is(secondItem));
    }

    @Test
    public void whenTrackerContainsSeveralItemsDeleteMiddleItemThenMiddleItemDeleted() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(Arrays.asList("3", secondItem.getId(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().size(), is(2));
        assertThat(tracker.findAll().get(0), is(firstItem));
        assertThat(tracker.findAll().get(1), is(thirdItem));
    }

    //findItemById() tests
    @Test
    public void whenFindItemByIdThenItemFound() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(Arrays.asList("4", item.getId(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenFindItemByIdWithInvalidIdThenItemNotFound() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Item firstItem = new Item("first name", "first desc");
        Input input = new StubInput(Arrays.asList("4", firstItem.getId(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(firstItem.getId()), is(nullValue()));
    }

    @Test
    public void whenTrackerContainsSeveralItemsFindFirstItemByIdThenFirstItemFound() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(Arrays.asList("4", firstItem.getId(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0), is(firstItem));
    }

    @Test
    public void whenTrackerContainsSeveralItemsFindLastItemByIdThenLastItemFound() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(Arrays.asList("4", thirdItem.getId(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(2), is(thirdItem));
    }

    @Test
    public void whenTrackerContainsSeveralItemsFindMiddleItemByIdThenMiddleItemFound() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(Arrays.asList("4", secondItem.getId(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(1), is(secondItem));
    }

    //findItemByName() tests
    @Test
    public void whenFindItemByNameThenItemFound() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(Arrays.asList("5", item.getName(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName()).get(0), is(item));
    }

    @Test
    public void whenTrackerContainsSeveralItemsWithSameNameFindItemByNameThenAllItemsWithSpecifiedNameFound() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("name", "second desc"));
        Item thirdItem = tracker.add(new Item("name", "third desc"));
        Input input = new StubInput(Arrays.asList("5", secondItem.getName(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(secondItem.getName()).get(0), is(secondItem));
        assertThat(tracker.findByName(secondItem.getName()).get(1), is(thirdItem));
    }

    @Test
    public void whenFindItemByNameThenItemNotFound() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(Arrays.asList("5", item.getName() + "343434", "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName() + "343434").size(), is(0));
    }

    @Test
    public void whenTrackerContainsSeveralItemsFindFirstItemByNameThenFirstItemFound() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(Arrays.asList("4", firstItem.getName(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(firstItem.getName()).get(0), is(firstItem));
    }

    @Test
    public void whenTrackerContainsSeveralItemsFindLastItemByNameThenLastItemFound() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(Arrays.asList("4", thirdItem.getName(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(thirdItem.getName()).get(0), is(thirdItem));
    }

    @Test
    public void whenTrackerContainsSeveralItemsFindMiddleItemByNameThenMiddleItemFound() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(Arrays.asList("4", secondItem.getName(), "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(secondItem.getName()).get(0), is(secondItem));
    }
}
