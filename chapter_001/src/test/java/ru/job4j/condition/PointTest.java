package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестов для формулы расчета идеального веса.
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 11/24/2018
 */
public class PointTest {
    @Test
    public void whenFirstPointAndSecondPointThenCorrectDistanceBetweenPoints() {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        assertThat(b.distanceTo(a), closeTo(4.4721, 0.1));
    }

    @Test
    public void whenDistanceBetweenFirstPointAndSecondPointThenDistanceTheSameBetweenSecondPointAndFirstPoint() {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        assertThat(b.distanceTo(a), closeTo(a.distanceTo(b), 0.1));
    }
}
