package ru.job4j.calculator;

/**
 * Class for computing addition, subtraction, division, multiplication.
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 11/10/2018
 */
public class Calculator {

    /*
     * Contains result of either addition or subtraction or multiplication or division.
     */
    private double result;

    /**
     * Method add.
     * Sum first and second.
     * @param first
     * @param second
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method subtract.
     * Subtract first and second.
     * @param first
     * @param second
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method div.
     * Divide first and second.
     * @param first
     * @param second
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method multiple.
     * Multiply first and second.
     * @param first
     * @param second
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method getResult.
     * @return result.
     */
    public double getResult() {
        return this.result;
    }
}
