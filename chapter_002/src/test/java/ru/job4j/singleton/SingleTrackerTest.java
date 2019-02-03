package ru.job4j.singleton;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * SingleTrackerTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 02/03/2019
 */
public class SingleTrackerTest {

    @Test
    public void whenFirstSingleTrackerThenOnlyOneInstance() {
        FirstSingleTracker firstTracker = FirstSingleTracker.INSTANCE;
        FirstSingleTracker secondTracker = FirstSingleTracker.INSTANCE;
        FirstSingleTracker thirdTracker = FirstSingleTracker.INSTANCE;
        assertTrue(firstTracker.equals(secondTracker));
        assertTrue(firstTracker.equals(thirdTracker));
        assertTrue(secondTracker.equals(thirdTracker));
    }

    @Test
    public void whenSecondSingleTrackerThenOnlyOneInstance() {
        SecondSingleTracker firstTracker = SecondSingleTracker.getInstance();
        SecondSingleTracker secondTracker = SecondSingleTracker.getInstance();
        SecondSingleTracker thirdTracker = SecondSingleTracker.getInstance();
        assertTrue(firstTracker.equals(secondTracker));
        assertTrue(firstTracker.equals(thirdTracker));
        assertTrue(secondTracker.equals(thirdTracker));
    }

    @Test
    public void whenThirdSingleTrackerThenOnlyOneInstance() {
        ThirdSingleTracker firstTracker = ThirdSingleTracker.getInstance();
        ThirdSingleTracker secondTracker = ThirdSingleTracker.getInstance();
        ThirdSingleTracker thirdTracker = ThirdSingleTracker.getInstance();
        assertTrue(firstTracker.equals(secondTracker));
        assertTrue(firstTracker.equals(thirdTracker));
        assertTrue(secondTracker.equals(thirdTracker));
    }

    @Test
    public void whenFourthSingleTrackerThenOnlyOneInstance() {
        FourthSingleTracker firstTracker = FourthSingleTracker.getInstance();
        FourthSingleTracker secondTracker = FourthSingleTracker.getInstance();
        FourthSingleTracker thirdTracker = FourthSingleTracker.getInstance();
        assertTrue(firstTracker.equals(secondTracker));
        assertTrue(firstTracker.equals(thirdTracker));
        assertTrue(secondTracker.equals(thirdTracker));
    }
}
