package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Tracker.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/25/2018
 */
public class Tracker {

    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * generateId.
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описания. Для идентификации нам нужен уникальный ключ.
     *
     * @return уникальный ключ для заявки.
     */
    private String generateId() {
        Random rand = new Random();
        return String.valueOf(System.currentTimeMillis() + rand.nextInt(100));
    }

    /**
     * add.
     * Метод, реализующий добавление заявки в хранилище.
     *
     * @param item новая заявка.
     * @return добавленная заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * replace.
     * Метод проходит по всем элементам массива и если уникальный ключ переданной заявки
     * совпадает с уникальным ключом заявки из массива, то заменяет заявку в массиве и выходит из цикла,
     * при замене генерируется уникальный ключ для заявки.
     * Возращает результат замены (true -- если удалось заменить, false -- если не удалось заменить).
     *
     * @param id   уникальный ключ для заявки.
     * @param item заявка.
     * @return результат замены.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                this.items[index] = item;
                this.items[index].setId(this.generateId());
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * delete.
     * Метод проходит по всем элементам массива и если уникальный ключ переданной заявки
     * совпадает с уникальным ключом заявки из массива,
     * то удаляет такую заявку из массива смещением всех элементов справа от такой заявки на одну ячейку влево.
     * Количество заполненных ячеек в массиве с заявками при этом уменьшается на 1.
     * Если уникальный ключ переданной заявки совпадает с уникальным ключом последней заявки в массиве,
     * то последняя заявка в массиве не заменяется.
     * Но количество заполненных ячеек в массиве с заявками при этом уменьшается на 1.
     * Возращает результат удаления (true -- если удалось удалить, false -- если не удалось удалить).
     *
     * @param id уникальный ключ для заявки.
     * @return результат удаления.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, this.items, index, this.position - index - 1);
                this.position--;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * findAll.
     * Метод возвращает все заявки из массива без null элементов.
     *
     * @return копия массива, содержащего заявки, без null элементов;
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * findByName.
     * Метод проходит весь массив с заявками, сравнивает имя заявки из параметра с именем каждой заявки из массива,
     * если находит совпадение, то добавляет такую заявку в результируюший массив, который потом возвращается.
     *
     * @param key имя заявки.
     * @return массив заявок, имеющих имя, совпадающее с именем заявки из параметра.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int counter = 0;
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getName().equals(key)) {
                result[counter] = this.items[index];
                counter++;
            }
        }
        return result;
    }

    /**
     * findById.
     * Метод проходит весь массив с заявками, сравнивает уникальный идентификатор заявки из параметра
     * с уникальным идентификатором каждой заявки из массива, возвращает первую заявку, чей уникальный идентификатор совпадает
     * с уникальным идентификатором из параметра, если такой заявки не найдено, то возвращает null;
     *
     * @param id уникальный идентификатор заявки.
     * @return заявка с уникальным идентификатором из параметра, или null, если такой заявки нет.
     */
    public Item findById(String id) {
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                return this.items[index];
            }
        }
        return null;
    }
}

