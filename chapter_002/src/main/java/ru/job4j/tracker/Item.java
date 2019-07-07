package ru.job4j.tracker;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * Item.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12 /25/2018
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
    private List<String> comments;

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

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     * @return the id
     */
    public Item setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     * @return the name
     */
    public Item setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets desc.
     *
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets desc.
     *
     * @param desc the desc
     * @return the desc
     */
    public Item setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    /**
     * Gets created.
     *
     * @return the created
     */
    public long getCreated() {
        return created;
    }

    /**
     * Sets created.
     *
     * @param created the created
     * @return the created
     */
    public Item setCreated(long created) {
        this.created = created;
        return this;
    }

    /**
     * Gets comments.
     *
     * @return the comments
     */
    public List<String> getComments() {
        return comments;
    }

    /**
     * Sets comments.
     *
     * @param comments the comments
     * @return the comments
     */
    public Item setComments(List<String> comments) {
        this.comments = comments;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Item item = (Item) o;

        return new EqualsBuilder()
            .append(id, item.id)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(id)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", id)
            .append("name", name)
            .append("desc", desc)
            .append("created", created)
            .append("comments", comments)
            .toString();
    }
}
