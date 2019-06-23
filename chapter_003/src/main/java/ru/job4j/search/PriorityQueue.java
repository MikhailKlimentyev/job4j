package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять элемент в нужную позицию.
     * Позиция должна определяться по полю приоритет.
     * Для вставки нужно использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        for (Task taskItem : tasks) {
            if (task.getPriority() <= taskItem.getPriority()) {
                tasks.add(index, task);
                return;
            }
            index++;
        }
        tasks.addLast(task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
