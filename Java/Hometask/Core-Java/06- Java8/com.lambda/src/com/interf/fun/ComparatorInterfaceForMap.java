package com.interf.fun;
import javax.swing.text.html.parser.Entity;
import java.util.*;

@FunctionalInterface
public interface ComparatorInterfaceForMap extends Comparator<Map.Entry<String,Integer>>
{   @Override
    public int compare(Map.Entry<String,Integer> map1, Map.Entry<String,Integer> map2);
}
