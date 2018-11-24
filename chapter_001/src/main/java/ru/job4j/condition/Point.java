package ru.job4j.condition;

import static java.lang.Math.*;

/**
 * Формула для расчета расстояния между точками.
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 11/23/2018
 */
public class Point {
    /*
     * Содержит значение координаты X
     */
    private int x;
    /*
     * Содержит значение координаты Y
     */
    private int y;

    /**
     * Конструктор.
     * @param x координата X
     * @param y координата Y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * distanceTo рассчитывает расстояние между двумя точками.
     * @param that точка
     * @return расстояние между двумя точками
     */
    public double distanceTo(Point that) {
        return sqrt(pow(that.x - this.x, 2.0) + (pow(that.y - this.y, 2.0)));
    }

}