package ru.job4j.tracker;

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

    public Item(String name, String desc, long created) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
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
