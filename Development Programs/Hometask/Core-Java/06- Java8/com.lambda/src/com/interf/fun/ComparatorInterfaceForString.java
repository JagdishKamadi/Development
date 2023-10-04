package com.interf.fun;
import java.util.Comparator;

public interface ComparatorInterfaceForString extends Comparator<String>
{
    @Override
    public int compare(String str1,String str2);
}

