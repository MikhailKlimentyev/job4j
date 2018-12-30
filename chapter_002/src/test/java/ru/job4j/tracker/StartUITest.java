package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * StartUITest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/30/2018
 */
public class StartUITest {
    //createItem() test
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    //showAllItems() tests
    @Test
    public void whenTrackerContainsSingleItemShowAllItemsThenSingleItemsReturned() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(1));
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenTrackerContainsSeveralItemsShowAllItemsThenAllItemsReturned() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(3));
        assertThat(tracker.findAll()[0], is(firstItem));
        assertThat(tracker.findAll()[1], is(secondItem));
        assertThat(tracker.findAll()[2], is(thirdItem));
    }

    //editItem() tests
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"2", "replaced name", "replaced desc", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("replaced name"));
        assertThat(tracker.findAll()[0].getDesc(), is("replaced desc"));
    }

    @Test
    public void whenUpdateWithInvalidIdThenItemNotUpdated() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"2", "replaced name", "replaced desc", item.getId() + "0", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenTrackerContainsSeveralItemsUpdateFirstItemThenTrackerHasSameNumberOfItemsAndFirstItemUpdated() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(new String[]{"2", "replaced name", "replaced desc", firstItem.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(3));
        assertThat(tracker.findAll()[0].getName(), is("replaced name"));
        assertThat(tracker.findAll()[0].getDesc(), is("replaced desc"));
    }

    @Test
    public void whenTrackerContainsSeveralItemsUpdateLastItemThenTrackerHasSameNumberOfItemsAndLastItemUpdated() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(new String[]{"2", "replaced name", "replaced desc", thirdItem.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(3));
        assertThat(tracker.findAll()[2].getName(), is("replaced name"));
        assertThat(tracker.findAll()[2].getDesc(), is("replaced desc"));
    }

    @Test
    public void whenTrackerContainsSeveralItemsUpdateMiddleItemThenTrackerHasSameNumberOfItemsAndMiddleItemUpdated() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(new String[]{"2", "replaced name", "replaced desc", secondItem.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(3));
        assertThat(tracker.findAll()[1].getName(), is("replaced name"));
    }

    //deleteItem() tests
    @Test
    public void whenDeleteThenItemDeleted() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(0));
    }

    @Test
    public void whenDeleteItemWithInvalidIdThenItemNotDeleted() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"3", "1" + item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(1));
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenTrackerContainsSeveralItemsDeleteFirstItemThenFirstItemDeleted() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(new String[]{"3", firstItem.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(2));
        assertThat(tracker.findAll()[0], is(secondItem));
        assertThat(tracker.findAll()[1], is(thirdItem));
    }

    @Test
    public void whenTrackerContainsSeveralItemsDeleteLastItemThenLastItemDeleted() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(new String[]{"3", thirdItem.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(2));
        assertThat(tracker.findAll()[0], is(firstItem));
        assertThat(tracker.findAll()[1], is(secondItem));
    }

    @Test
    public void whenTrackerContainsSeveralItemsDeleteMiddleItemThenMiddleItemDeleted() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(new String[]{"3", secondItem.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(2));
        assertThat(tracker.findAll()[0], is(firstItem));
        assertThat(tracker.findAll()[1], is(thirdItem));
    }

    //findItemById() tests
    @Test
    public void whenFindItemByIdThenItemFound() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenFindItemByIdWithInvalidIdThenItemNotFound() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Item firstItem = new Item("first name", "first desc");
        Input input = new StubInput(new String[]{"4", firstItem.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(firstItem.getId()), is(nullValue()));
    }

    @Test
    public void whenTrackerContainsSeveralItemsFindFirstItemByIdThenFirstItemFound() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(new String[]{"4", firstItem.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0], is(firstItem));
    }

    @Test
    public void whenTrackerContainsSeveralItemsFindLastItemByIdThenLastItemFound() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(new String[]{"4", thirdItem.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[2], is(thirdItem));
    }

    @Test
    public void whenTrackerContainsSeveralItemsFindMiddleItemByIdThenMiddleItemFound() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(new String[]{"4", secondItem.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[1], is(secondItem));
    }

    //findItemByName() tests
    @Test
    public void whenFindItemByNameThenItemFound() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName())[0], is(item));
    }

    @Test
    public void whenTrackerContainsSeveralItemsWithSameNameFindItemByNameThenAllItemsWithSpecifiedNameFound() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("name", "second desc"));
        Item thirdItem = tracker.add(new Item("name", "third desc"));
        Input input = new StubInput(new String[]{"5", secondItem.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(secondItem.getName())[0], is(secondItem));
        assertThat(tracker.findByName(secondItem.getName())[1], is(thirdItem));
        assertThat(tracker.findByName(secondItem.getName())[2], is(nullValue()));
    }

    @Test
    public void whenFindItemByNameThenItemNotFound() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getName() + "343434", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName() + "343434")[0], is(nullValue()));
    }

    @Test
    public void whenTrackerContainsSeveralItemsFindFirstItemByNameThenFirstItemFound() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(new String[]{"4", firstItem.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(firstItem.getName())[0], is(firstItem));
    }

    @Test
    public void whenTrackerContainsSeveralItemsFindLastItemByNameThenLastItemFound() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(new String[]{"4", thirdItem.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(thirdItem.getName())[0], is(thirdItem));
    }

    @Test
    public void whenTrackerContainsSeveralItemsFindMiddleItemByNameThenMiddleItemFound() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("first name", "first desc"));
        Item secondItem = tracker.add(new Item("second name", "second desc"));
        Item thirdItem = tracker.add(new Item("third name", "third desc"));
        Input input = new StubInput(new String[]{"4", secondItem.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(secondItem.getName())[0], is(secondItem));
    }
}
