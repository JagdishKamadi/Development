package com.interf.fun;

import java.util.Comparator;

public interface ComparatorInterfaceForEmployee extends Comparator<Employee> {
    public int compare(Employee e1,Employee e2);
}
