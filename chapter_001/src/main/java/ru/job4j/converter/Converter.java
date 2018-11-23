package ru.job4j.converter;

/**
 * Конвертер валюты.
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 11/22/2018
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return евро.
     */
    public int rubleToEuro(int value) {
        return value / 74;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return доллары.
     */
    public int rubleToDollar(int value) {
        return value / 66;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return рубли.
     */
    public int euroToRuble(int value) {
        return value * 74;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return рубли.
     */
    public int dollarToRuble(int value) {
        return value * 66;
    }
}


