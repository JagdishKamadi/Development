package com.interf.fun;

import java.util.Comparator;

/*
    We are sorting the element base on lambda expression
    using comparator interface, we can directly sort with the help of comparator class
    by creating interface object
 */
@FunctionalInterface
public
interface ComparatorInterfacefForInteger extends Comparator<Integer>
{
    @Override
    public int compare(Integer a,Integer b);
}

