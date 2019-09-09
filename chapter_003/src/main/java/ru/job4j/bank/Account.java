package ru.job4j.bank;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Account {

    private double value;
    private String requisites;

    /**
     * Instantiates a new Account.
     *
     * @param value      the value
     * @param requisites the requisites
     */
    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     * @return {@link Account} account
     */
    public Account setValue(double value) {
        this.value = value;
        return this;
    }

    /**
     * Gets requisites.
     *
     * @return the requisites
     */
    public String getRequisites() {
        return requisites;
    }

    /**
     * Sets requisites.
     *
     * @param requisites the requisites
     * @return {@link Account} account
     */
    public Account setRequisites(String requisites) {
        this.requisites = requisites;
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

        Account account = (Account) o;

        return new EqualsBuilder()
            .append(value, account.value)
            .append(requisites, account.requisites)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(value)
            .append(requisites)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("value", value)
            .append("requisites", requisites)
            .toString();
    }
}
