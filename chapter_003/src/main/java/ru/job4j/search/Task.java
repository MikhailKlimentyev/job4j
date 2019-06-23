package ru.job4j.search;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Task {

    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("desc", desc)
            .append("priority", priority)
            .toString();
    }
}
