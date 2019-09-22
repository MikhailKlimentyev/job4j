package ru.job4j.exam;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * The type Department sorting test.
 */
public class DepartmentSortingTest {
    /**
     * T.
     */
    @Test
    public void whenDepartmentsSortAscendThenMissingDepartmentsAddedAndAllDepartmentsSortedAscend() {
        DepartmentSorting departmentSorting = new DepartmentSorting();
        List<String> departments = Arrays.asList(
            "K1\\SK1",
            "K1\\SK2",
            "K1\\SK1\\SSK1",
            "K1\\SK1\\SSK2",
            "K2",
            "K2\\SK1\\SSK1",
            "K2\\SK1\\SSK2"
        );
        List<String> actualSortedDepartments = departmentSorting.sortAscend(departments);
        List<String> expectedSortedDepartments = Arrays.asList(
            "K1",
            "K1\\SK1",
            "K1\\SK1\\SSK1",
            "K1\\SK1\\SSK2",
            "K1\\SK2",
            "K2",
            "K2\\SK1",
            "K2\\SK1\\SSK1",
            "K2\\SK1\\SSK2"
        );
        assertThat(actualSortedDepartments, is(expectedSortedDepartments));
    }

    /**
     * T.
     */
    @Test
    public void whenDepartmentsSortDescendThenMissingDepartmentsAddedAndAllDepartmentsSortedDescend() {
        DepartmentSorting departmentSorting = new DepartmentSorting();
        List<String> departments = Arrays.asList(
            "K1\\SK1",
            "K1\\SK2",
            "K1\\SK1\\SSK1",
            "K1\\SK1\\SSK2",
            "K2",
            "K2\\SK1\\SSK1",
            "K2\\SK1\\SSK2"
        );
        List<String> actualSortedDepartments = departmentSorting.sortDescend(departments);
        List<String> expectedSortedDepartments = Arrays.asList(
            "K2",
            "K2\\SK1",
            "K2\\SK1\\SSK2",
            "K2\\SK1\\SSK1",
            "K1",
            "K1\\SK2",
            "K1\\SK1",
            "K1\\SK1\\SSK2",
            "K1\\SK1\\SSK1"
        );
        assertThat(actualSortedDepartments, is(expectedSortedDepartments));
    }
}
