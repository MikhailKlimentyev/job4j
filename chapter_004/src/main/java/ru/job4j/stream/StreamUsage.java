package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {

    public static class Task {

        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{" +
                "name='" + name + '\'' +
                ", spent=" + spent +
                '}';
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
            new Task("Bug #1", 100),
            new Task("Task #2", 100),
            new Task("Bug #3", 100)
        );
// ================================================================================
//      1. Фильтрация.
        List<Task> bugs = tasks.stream()
            .filter(task -> task.name.contains("Bug"))
            .collect(Collectors.toList());

        bugs.forEach(System.out::println);

//        Аналог решения через for each:
//        List<Task> container = new ArrayList<>();
//        for (Task task : tasks) {
//            if ("BUG".equals(task.name)) {
//                container.add(task);
//            }
//        }
// ================================================================================
//      2. Преобразование.
        List<String> names = tasks.stream()
            .map(task -> task.name)
            .collect(Collectors.toList());

//       Аналог через for:
//       List<String> container = new ArrayList<>();
//       for (Task task : tasks) {
//           container.add(task.name);
//       }
// ================================================================================
//      3. Упрощение или Хранение.
        long total = tasks.stream()
            .map(task -> task.spent)
            .reduce(0L, Long::sum);
//        T reduce(T identity, BinaryOperator<T> accumulator)

//        Аналог через for:
//        List<String> container = new ArrayList<>();
//        for (Task task : tasks) {
//            container.add(task.name);
//        }
//
//      Аналог через for:
//      long total = 0L;
//      for (Task task : tasks) {
//         total += task.spent;
//      }
// ================================================================================
    }
}
