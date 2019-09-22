package ru.job4j.exam;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * The type Department sorting.
 */
public class DepartmentSorting {
    /**
     * Sort ascend list.
     *
     * @param departments the departments
     * @return the list
     */
    public List<String> sortAscend(List<String> departments) {
        List<String> allUniqueDepartments = this.getAllHierarchyUniqueDepartments(departments);
        Collections.sort(allUniqueDepartments);
        return allUniqueDepartments;
    }

    /**
     * Sort descend list.
     *
     * @param departments the departments
     * @return the list
     */
    public List<String> sortDescend(List<String> departments) {
        List<String> allUniqueDepartments = this.getAllHierarchyUniqueDepartments(departments);
        Collections.sort(allUniqueDepartments,
            (firstDepartment, secondDepartment) -> {
                int comparisonResult = 0;
                if (firstDepartment.length() == secondDepartment.length()) {
                    comparisonResult = firstDepartment.compareTo(secondDepartment);
                    return -comparisonResult;
                } else {
                    List<String> firstDepartmentParts = this.getDepartmentParts(firstDepartment);
                    List<String> secondDepartmentParts = this.getDepartmentParts(secondDepartment);

                    Iterator<String> firstDepartmentIterator = firstDepartmentParts.iterator();
                    Iterator<String> secondDepartmentIterator = secondDepartmentParts.iterator();

                    while (firstDepartmentIterator.hasNext() && secondDepartmentIterator.hasNext()) {
                        comparisonResult = firstDepartmentIterator.next().compareTo(secondDepartmentIterator.next());
                        if (comparisonResult != 0) {
                            return -comparisonResult;
                        }
                    }
                    return Integer.compare(firstDepartment.length(), secondDepartment.length());
                }
            });
        return allUniqueDepartments;
    }

    private List<String> getDepartmentParts(String department) {
        int delimiterCount = StringUtils.countMatches(department, "\\");
        String group = "";
        String service = "";
        String division = "";
        List<String> departmentParts = null;
        if (delimiterCount == 0) {
            group = department;
            departmentParts = Collections.singletonList(group);
        } else if (delimiterCount == 1) {
            group = department.substring(0, 2);
            service = department;
            departmentParts = Arrays.asList(group, service);
        } else if (delimiterCount == 2) {
            group = department.substring(0, 2);
            service = department.substring(0, 6);
            division = department;
            departmentParts = Arrays.asList(group, service, division);
        }
        return departmentParts;
    }

    private List<String> getAllHierarchyUniqueDepartments(List<String> initialDepartments) {
        Set<String> allUniqueDepartments = new TreeSet<>(initialDepartments);
        for (String department : initialDepartments) {
            List<String> departmentParts = this.getDepartmentParts(department);
            allUniqueDepartments.addAll(departmentParts);
        }
        return new ArrayList<>(allUniqueDepartments);
    }
}

