package ru.job4j.pseudo;

/**
 * Paint.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 01/01/2019
 */
public class Paint {

    /**
     * draw().
     * draws in console.
     *
     * @param shape shape.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
