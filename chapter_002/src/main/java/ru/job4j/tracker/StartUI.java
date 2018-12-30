package ru.job4j.tracker;

/**
 * StartUI.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/29/2018
 */
public class StartUI {

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final ConsoleInput input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(ConsoleInput input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод запускает основной цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("\nPlease, select menu item: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (answer.equals("1")) {
                this.showAllItems();
            } else if (answer.equals("2")) {
                this.editItem();
            } else if (answer.equals("3")) {
                this.deleteItem();
            } else if (answer.equals("4")) {
                this.findItemById();
            } else if (answer.equals("5")) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод находит все заявки по имени и печатает в консоль их Id, Name и Description.
     */
    private void findItemByName() {
        String name = this.input.ask("Please, type name of items to be printed: ");
        Item[] items = this.tracker.findByName(name);
        for (int i = 0; i != items.length; i++) {
            if (items[i] != null) {
                System.out.println("Id: " + items[i].getId() + "; "
                        + " Name: " + items[i].getName() + "; "
                        + " Description: " + items[i].getDesc() + "; ");
            }
        }
        System.out.println("---------------------------------------");
    }

    /**
     * Метод находит заявку по id и печатает в консоль её Id, Name и Description.
     */
    private void findItemById() {
        String id = this.input.ask("Please, type id of item to be printed: ");
        Item item = this.tracker.findById(id);
        System.out.println("Id: " + item.getId() + "; "
                + " Name: " + item.getName() + "; "
                + " Description: " + item.getDesc() + "; ");
        System.out.println("---------------------------------------");
    }

    /**
     * Метод удаляет заявку с указанным id из хранилища.
     */
    private void deleteItem() {
        String id = this.input.ask("Please, type id of item to be deleted: ");
        if (this.tracker.delete(id)) {
            System.out.println("------------ Item with Id: " + id + " was successfully deleted -----------");
        } else {
            System.out.println("------------ There is no item with id: " + id + " -----------");
        }
    }

    /**
     * Метод заменяет заявку с указанным id в хранилище новой заявкой.
     */
    private void editItem() {
        String name = this.input.ask("Please, type item name: ");
        String desc = this.input.ask("Please, type item description: ");
        Item item = new Item(name, desc);
        String id = this.input.ask("Please, type id of item to be replaced: ");
        if (this.tracker.replace(id, item)) {
            System.out.println("------------ Item with Id: " + id + " was successfully replaced -----------");
        } else {
            System.out.println("------------ There is no item with id: " + id + " -----------");
        }
    }

    /**
     * Метод показывает все заявки в хранилище.
     */
    private void showAllItems() {
        System.out.println("------------ All items: --------------");
        Item[] items = this.tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            System.out.println(i + ". "
                    + "Id: " + items[i].getId() + "; "
                    + " Name: " + items[i].getName() + "; "
                    + " Description: " + items[i].getDesc() + "; ");
        }
        System.out.println("---------------------------------------");
    }

    /**
     * Метод реализует добавления новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Adding of a new item --------------");
        String name = this.input.ask("Please, type item name: ");
        String desc = this.input.ask("Please, type item description: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ New item with Id: " + item.getId() + " is created -----------");
    }

    /**
     * Метод выводит меню консоль.
     */
    private void showMenu() {
        System.out.println("\nMenu:\n"
                + "0. Add new item\n"
                + "1. Show all items\n"
                + "2. Edit item\n"
                + "3. Delete item\n"
                + "4. Find item by Id\n"
                + "5. Find items by name\n"
                + "6. Exit Program");
    }

    /**
     * Метод запускает программу.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
