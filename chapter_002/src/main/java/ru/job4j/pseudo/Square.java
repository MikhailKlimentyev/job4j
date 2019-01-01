package ru.job4j.pseudo;

/**
 * Square.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 01/01/2019
 */
public class Square implements Shape {

    /**
     * draw().
     *
     * @return square as a string.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++");
        pic.append("+  +");
        pic.append("+  +");
        pic.append("++++");
        return pic.toString();
    }
}
