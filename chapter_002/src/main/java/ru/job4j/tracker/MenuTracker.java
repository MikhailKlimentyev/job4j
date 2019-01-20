package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * MenuTracker.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 01/04/2018
 */
public class MenuTracker {
    /**
     * Получение данных от пользователя.
     */
    private Input input;

    /**
     * Хранилище заявок.
     */
    private Tracker tracker;

    /**
     * Хранилище пунктов меню.
     */
    private UserAction[] actions = new UserAction[7];

    /**
     * Конструктор.
     *
     * @param input   объект класса, который реализуюет интерфейс Input.
     * @param tracker объект класса Tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * getActionsLength.
     * Метод для количества пунктов меню.
     *
     * @return количество пунктов меню.
     */
    public int getActionsLength() {
        return this.actions.length;
    }

    /**
     * fillActions.
     * Метод заполняет хранилище пунктов меню.
     *
     * @param ui ссылка на объект класса StartUI.
     */
    public void fillActions(StartUI ui) {
        actions[0] = new AddItem(0, "Add new item");
        actions[1] = new ShowItems(1, "Show all items");
        actions[2] = new UpdateItem(2, "Edit item");
        actions[3] = new DeleteItem(3, "Delete item");
        actions[4] = new FindItemById(4, "Find item by Id");
        actions[5] = new FindItemsByname(5, "Find items by name");
        actions[6] = new ExitProgram(6, "Exit Program", ui);
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующий пункт меню.
     *
     * @param key ключ операции.
     */
    public void select(int key) {
        for (int i = 0; i < this.actions.length; i++) {
            if (i == key) {
                this.actions[i].execute(this.input, this.tracker);
            }
        }
    }

    /**
     * show.
     * Метод выводит на экран информацию о каждом пункте меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * AddItem.
     */
    private class AddItem extends BaseAction {
        /**
         * Конструктор.
         *
         * @param number Номер пункта в меню.
         * @param name   Название пункта в меню.
         */
        public AddItem(int number, String name) {
            super(number, name);
        }

        /**
         * execute.
         * Метод реализует добавления новой заявки в хранилище.
         *
         * @param input   объект типа Input.
         * @param tracker объект типа Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding of a new item --------------");
            String name = input.ask("Please, type item name: ");
            String desc = input.ask("Please, type item description: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ New item with Id: " + item.getId() + " is created -----------");
        }
    }

    /**
     * ShowItems.
     */
    private class ShowItems extends BaseAction {
        /**
         * Конструктор.
         *
         * @param number Номер пункта в меню.
         * @param name   Название пункта в меню.
         */
        public ShowItems(int number, String name) {
            super(number, name);
        }

        /**
         * execute.
         * Метод печатает все заявки из хранилища в консоль.
         *
         * @param input   объект типа Input.
         * @param tracker объект типа Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ All items: --------------");
            Item[] items = tracker.findAll();
            for (int i = 0; i < items.length; i++) {
                System.out.println(i + ". " + items[i].toString());
            }
            System.out.println("---------------------------------------");
        }
    }

    /**
     * UpdateItem.
     */
    private class UpdateItem extends BaseAction {
        /**
         * Конструктор.
         *
         * @param number Номер пункта в меню.
         * @param name   Название пункта в меню.
         */
        public UpdateItem(int number, String name) {
            super(number, name);
        }

        /**
         * execute.
         * Метод заменяет заявку с указанным id в хранилище новой заявкой.
         *
         * @param input   объект типа Input.
         * @param tracker объект типа Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, type item name: ");
            String desc = input.ask("Please, type item description: ");
            Item item = new Item(name, desc);
            String id = input.ask("Please, type id of item to be replaced: ");
            if (tracker.replace(id, item)) {
                System.out.println("------------ Item with Id: " + id + " was successfully replaced -----------");
            } else {
                System.out.println("------------ There is no item with id: " + id + " -----------");
            }
        }
    }

    /**
     * DeleteItem.
     */
    private class DeleteItem extends BaseAction {
        /**
         * Конструктор.
         *
         * @param number Номер пункта в меню.
         * @param name   Название пункта в меню.
         */
        public DeleteItem(int number, String name) {
            super(number, name);
        }

        /**
         * execute.
         * Метод удаляет заявку с указанным id из хранилища.
         *
         * @param input   объект типа Input.
         * @param tracker объект типа Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, type id of item to be deleted: ");
            if (tracker.delete(id)) {
                System.out.println("------------ Item with Id: " + id + " was successfully deleted -----------");
            } else {
                System.out.println("------------ There is no item with id: " + id + " -----------");
            }
        }
    }

    /**
     * FindItemById.
     */
    private class FindItemById extends BaseAction {
        /**
         * Конструктор.
         *
         * @param number Номер пункта в меню.
         * @param name   Название пункта в меню.
         */
        public FindItemById(int number, String name) {
            super(number, name);
        }

        /**
         * execute.
         * Метод находит заявку по id и печатает в консоль её Id, name и Description.
         *
         * @param input   объект типа Input.
         * @param tracker объект типа Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, type id of item to be printed: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item.toString());
            } else {
                System.out.println("------------ There is no item with id: " + id + " -----------");
            }
            System.out.println("---------------------------------------");
        }
    }

    /**
     * FindItemsByname.
     */
    private class FindItemsByname extends BaseAction {
        /**
         * Конструктор.
         *
         * @param number Номер пункта в меню.
         * @param name   Название пункта в меню.
         */
        public FindItemsByname(int number, String name) {
            super(number, name);
        }

        /**
         * execute.
         * Метод находит все заявки по имени и печатает в консоль их Id, name и Description.
         *
         * @param input   объект типа Input.
         * @param tracker объект типа Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, type name of items to be printed: ");
            Item[] items = tracker.findByName(name);
            for (int i = 0; i != items.length; i++) {
                if (items[i] != null) {
                    System.out.println(items[i].toString());
                }
            }
            System.out.println("---------------------------------------");
        }
    }

    /**
     * ExitProgram.
     */
    private class ExitProgram extends BaseAction {
        /**
         * Ссылка на объект класса StartUI.
         */
        private final StartUI ui;

        /**
         * Конструктор.
         *
         * @param number Номер пункта в меню.
         * @param name   Название пункта в меню.
         * @param ui     ссылка на объект класса StartUI.
         */
        public ExitProgram(int number, String name, StartUI ui) {
            super(number, name);
            this.ui = ui;
        }

        /**
         * execute.
         * Метод останавливает выполнение основного цикла программы.
         *
         * @param input   объект типа Input.
         * @param tracker объект типа Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Program has been stopped ------------------");
            this.ui.stop();
        }
    }
}
