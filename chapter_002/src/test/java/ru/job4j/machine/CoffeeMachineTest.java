package ru.job4j.machine;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * The type Coffee machine test.
 */
@RunWith(DataProviderRunner.class)
public class CoffeeMachineTest {

    /**
     * Test when value and price then valid сhange.
     *
     * @param value         the value
     * @param price         the price
     * @param expectedArray the expected array
     */
    @Test
    @UseDataProvider("dataProviderCoffeeMachine")
    public void testWhenValueAndPriceThenValidChange(int value, int price, int[] expectedArray) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] actualArray = coffeeMachine.changes(value, price);
        Assert.assertArrayEquals(actualArray, expectedArray);
    }

    /**
     * Data provider coffee machine object [ ] [ ].
     *
     * @return the object [ ] [ ]
     */
    @DataProvider
    public static Object[][] dataProviderCoffeeMachine() {
        return new Object[][]{
            {10, 5, new int[]{5}},
            {10, -1, new int[]{0}},
            {-1, 4, new int[]{0}},
            {2, -1, new int[]{0}},
            {-1, -1, new int[]{0}},
            {0, 0, new int[]{0}},
            {1, 0, new int[]{1}},
            {0, 1, new int[]{0}},
            {36, 17, new int[]{10, 5, 2, 2}},
            {50, 35, new int[]{10, 5}},
            {51, 35, new int[]{10, 5, 1}},
            {50, 1, new int[]{10, 10, 10, 10, 5, 2, 2}}
        };
    }
}
