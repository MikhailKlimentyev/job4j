package ru.job4j.pseudo;

/**
 * Triangle.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 01/01/2019
 */
public class Triangle implements Shape {

    /**
     * draw().
     *
     * @return triangle as a string.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +   ");
        pic.append("  +++  ");
        pic.append(" +++++ ");
        pic.append("+++++++");
        return pic.toString();
    }
}
