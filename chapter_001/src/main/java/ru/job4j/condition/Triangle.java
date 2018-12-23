package ru.job4j.condition;

/**
 * Triangle.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 26/11/2018
 */
public class Triangle {
    /*
     * Содержит значение точки a
     */
    private Point a;
    /*
     * Содержит значение точки b
     */
    private Point b;
    /*
     * Содержит значение точки c
     */
    private Point c;

    /**
     * Конструктор.
     *
     * @param a точка a
     * @param b точка b
     * @param c точка c
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисляет полупериметр по длинам сторон.
     * <p>
     * Формула.
     * <p>
     * (ab + ac + bc) / 2
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return Перимент.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Метод вычисляет площадь треугольника.
     *
     * @return возвращает площадь, если треугольник существует, или -1, если треугольник не существует.
     */
    public double area() {
        double result = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            result = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return result;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     * <p>
     * У треугольника сумма любых двух сторон должна быть больше третьей.
     * <p>
     * Иначе две стороны просто "лягут" на третью и треугольника не получится.
     *
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @return
     */
    private boolean exist(double ab, double ac, double bc) {
        return (ab + ac > bc && ab + bc > ac && ac + bc > ab);
    }
}
