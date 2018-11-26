package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * TriangleTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 11/26/2018
 */
public class TriangleTest {

    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);

        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));
    }

    @Test
    public void whenSumOfTwoSidesLessThanThirdSideThenNoTriangleArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 1);
        Point c = new Point(0, 2);

        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = -1D;
        assertThat(result, closeTo(expected, 0.1));
    }

    @Test
    public void whenSumOfTwoSidesLessThanThirdSideThenPeriod() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 1);
        Point c = new Point(0, 2);

        double ab = a.distanceTo(b);
        double ac = a.distanceTo(c);
        double bc = b.distanceTo(c);

        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.period(ab, ac, bc);
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));
    }

    @Test
    public void whenSumOfTwoSidesMoreThanThirdSideThenPeriod() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);

        double ab = a.distanceTo(b);
        double ac = a.distanceTo(c);
        double bc = b.distanceTo(c);

        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.period(ab, ac, bc);
        double expected = 3.4D;
        assertThat(result, closeTo(expected, 0.1));
    }
}
