package ru.job4j.tracker;

import java.util.Arrays;

/**
 * Item.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/25/2018
 */
public class Item {
    /**
     * Уникальный идентификатор заявки.
     */
    private String id;

    /**
     * Имя заявки.
     */
    private String name;

    /**
     * Описание заявки.
     */
    private String desc;

    /**
     * Дата создания заявки.
     */
    private long created;

    /**
     * Комментарии.
     */
    private String[] comments;

    /**
     * Item.
     * Конструктор.
     *
     * @param name уникальный идентификатор заявки.
     * @param desc описание заявки.
     */
    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.created = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", created=" + created +
                ", comments=" + Arrays.toString(comments) +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public long getCreated() {
        return created;
    }

    public String[] getComments() {
        return comments;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }
}
