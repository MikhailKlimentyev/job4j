package ru.job4j.stream;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The type Address.
 */
public class Address {

    private String city;
    private String street;
    private int home;
    private int apartment;

    /**
     * Instantiates a new Address.
     */
    public Address() {
    }

    /**
     * Instantiates a new Address.
     *
     * @param city the city
     */
    public Address(String city) {
        this.city = city;
    }

    /**
     * Instantiates a new Address.
     *
     * @param city      the city
     * @param street    the street
     * @param home      the home
     * @param apartment the apartment
     */
    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     * @return {@link Address} address
     */
    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * Gets street.
     *
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets street.
     *
     * @param street the street
     * @return {@link Address} address
     */
    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    /**
     * Gets home.
     *
     * @return the home
     */
    public int getHome() {
        return home;
    }

    /**
     * Sets home.
     *
     * @param home the home
     * @return {@link Address} address
     */
    public Address setHome(int home) {
        this.home = home;
        return this;
    }

    /**
     * Gets apartment.
     *
     * @return the apartment
     */
    public int getApartment() {
        return apartment;
    }

    /**
     * Sets apartment.
     *
     * @param apartment the apartment
     * @return {@link Address} address
     */
    public Address setApartment(int apartment) {
        this.apartment = apartment;
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

        Address address = (Address) o;

        return new EqualsBuilder()
            .append(home, address.home)
            .append(apartment, address.apartment)
            .append(city, address.city)
            .append(street, address.street)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(city)
            .append(street)
            .append(home)
            .append(apartment)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("city", city)
            .append("street", street)
            .append("home", home)
            .append("apartment", apartment)
            .toString();
    }
}
