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
    private List<UserAction> actions = new ArrayList<>();

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
        return this.actions.size();
    }

    /**
     * Метод заполняет хранилище пунктов меню.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add new item"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new UpdateItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByname(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующий пункт меню.
     *
     * @param key ключ операции.
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
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
    private class AddItem implements UserAction {
        /**
         * Номер пункта Add Item в меню.
         */
        private final int number;

        /**
         * Название пункта Add Item в меню.
         */
        private final String name;

        /**
         * Конструктор.
         *
         * @param number Номер пункта в меню.
         * @param name   Название пункта в меню.
         */
        public AddItem(int number, String name) {
            this.number = number;
            this.name = name;
        }

        /**
         * key.
         * Метод возвращает номер пункта меню Add Item.
         *
         * @return номер пункта меню.
         */
        @Override
        public int key() {
            return number;
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

        /**
         * info.
         * Метод возвращает информацию(ключ и описание) о пункте меню Add Item.
         *
         * @return информацию(ключ и описание) о пункте меню.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), this.name);
        }
    }

    /**
     * ShowItems.
     */
    private class ShowItems implements UserAction {
        /**
         * Номер пункта Show Items в меню.
         */
        private final int number;

        /**
         * Название пункта Show Items в меню.
         */
        private final String name;

        /**
         * Конструктор.
         *
         * @param number Номер пункта в меню.
         * @param name   Название пункта в меню.
         */
        public ShowItems(int number, String name) {
            this.number = number;
            this.name = name;
        }

        /**
         * key.
         * Метод возвращает номер пункта меню Show Items.
         *
         * @return номер пункта меню.
         */
        @Override
        public int key() {
            return number;
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

        /**
         * info.
         * Метод возвращает информацию(ключ и описание) о пункте меню Show Items.
         *
         * @return информацию(ключ и описание) о пункте меню.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), this.name);
        }
    }

    /**
     * UpdateItem.
     */
    private class UpdateItem implements UserAction {
        /**
         * Номер пункта Update Item в меню.
         */
        private final int number;

        /**
         * Название пункта Update Item в меню.
         */
        private final String name;

        /**
         * Конструктор.
         *
         * @param number Номер пункта в меню.
         * @param name   Название пункта в меню.
         */
        public UpdateItem(int number, String name) {
            this.number = number;
            this.name = name;
        }

        /**
         * key.
         * Метод возвращает номер пункта меню Update Item.
         *
         * @return номер пункта меню.
         */
        @Override
        public int key() {
            return number;
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

        /**
         * info.
         * Метод возвращает информацию(ключ и описание) о пункте меню Update Item.
         *
         * @return информацию(ключ и описание) о пункте меню.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), this.name);
        }
    }

    /**
     * DeleteItem.
     */
    private class DeleteItem implements UserAction {
        /**
         * Номер пункта Delete Item в меню.
         */
        private final int number;

        /**
         * Название пункта Delete Item в меню.
         */
        private final String name;

        /**
         * Конструктор.
         *
         * @param number Номер пункта в меню.
         * @param name   Название пункта в меню.
         */
        public DeleteItem(int number, String name) {
            this.number = number;
            this.name = name;
        }

        /**
         * key.
         * Метод возвращает номер пункта меню Delete Item.
         *
         * @return номер пункта меню.
         */
        @Override
        public int key() {
            return number;
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

        /**
         * info.
         * Метод возвращает информацию(ключ и описание) о пункте меню Delete Item.
         *
         * @return информацию(ключ и описание) о пункте меню.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), this.name);
        }
    }

    /**
     * FindItemById.
     */
    private class FindItemById implements UserAction {
        /**
         * Номер пункта Find Item By Id в меню.
         */
        private final int number;

        /**
         * Название пункта Find Item By Id в меню.
         */
        private final String name;

        /**
         * Конструктор.
         *
         * @param number Номер пункта в меню.
         * @param name   Название пункта в меню.
         */
        public FindItemById(int number, String name) {
            this.number = number;
            this.name = name;
        }

        /**
         * key.
         * Метод возвращает номер пункта меню Find Item By Id.
         *
         * @return номер пункта меню.
         */
        @Override
        public int key() {
            return number;
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

        /**
         * info.
         * Метод возвращает информацию(ключ и описание) о пункте меню Find Item By Id.
         *
         * @return информацию(ключ и описание) о пункте меню.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), this.name);
        }
    }

    /**
     * FindItemsByname.
     */
    private class FindItemsByname implements UserAction {
        /**
         * Номер пункта Find Items By name в меню.
         */
        private final int number;

        /**
         * Название пункта Find Items By name в меню.
         */
        private final String name;

        /**
         * Конструктор.
         *
         * @param number Номер пункта в меню.
         * @param name   Название пункта в меню.
         */
        public FindItemsByname(int number, String name) {
            this.number = number;
            this.name = name;
        }

        /**
         * key.
         * Метод возвращает номер пункта меню Find Items By name.
         *
         * @return номер пункта меню.
         */
        @Override
        public int key() {
            return number;
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

        /**
         * info.
         * Метод возвращает информацию(ключ и описание) о пункте меню Find Items By name.
         *
         * @return информацию(ключ и описание) о пункте меню.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), this.name);
        }

        /**
         * ExitProgram.
         */
    }

    private class ExitProgram implements UserAction {
        /**
         * Номер пункта Exit Program в меню.
         */
        private final int number;

        /**
         * Название пункта Exit Program в меню.
         */
        private final String name;

        /**
         * Конструктор.
         *
         * @param number Номер пункта в меню.
         * @param name   Название пункта в меню.
         */
        public ExitProgram(int number, String name) {
            this.number = number;
            this.name = name;
        }

        /**
         * key.
         * Метод возвращает номер пункта меню Exit Program.
         *
         * @return номер пункта меню.
         */
        @Override
        public int key() {
            return number;
        }

        /**
         * execute.
         *
         * @param input   объект типа Input.
         * @param tracker объект типа Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
        }

        /**
         * info.
         * Метод возвращает информацию(ключ и описание) о пункте меню Exit Program.
         *
         * @return информацию(ключ и описание) о пункте меню.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), this.name);
        }
    }
}
