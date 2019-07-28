package ru.job4j.bank;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class User {

    private String name;
    private String passport;

    /**
     * Instantiates a new User.
     *
     * @param name     the name
     * @param passport the passport
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
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
     * @return {@link User} user
     */
    public User setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets passport.
     *
     * @return the passport
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Sets passport.
     *
     * @param passport the passport
     * @return {@link User} user
     */
    public User setPassport(String passport) {
        this.passport = passport;
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

        User user = (User) o;

        return new EqualsBuilder()
            .append(name, user.name)
            .append(passport, user.passport)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(name)
            .append(passport)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("name", name)
            .append("passport", passport)
            .toString();
    }
}
