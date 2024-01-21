/*  Problem Statement
    Create a TreeMap that sorts the given set of values in decending order
 */

import java.util.*;
import com.interf.fun.*;

public class TreeMapClass {
    public static void main(String[] args) {

        // Create tree map
        Map<String, Integer> nameAgeData = new TreeMap<>();

        // add value
        nameAgeData.put("Madhur",21);
        nameAgeData.put("Jagdish",22);
        nameAgeData.put("Amit",20);
        nameAgeData.put("Kunal",20);
        nameAgeData.put("Jayant",19);
        nameAgeData.put("Harshal",23);

        // convert into the list(means receive each entry of map)
       List<Map.Entry<String,Integer>> list = new ArrayList<>(nameAgeData.entrySet());

        // lambda logic is here
        // apply the sorting base on keys
       ComparatorInterfaceForMap test = (entry1,entry2)->
       {
           return entry2.getKey().compareTo(entry1.getKey());
       };

        // sort the list now
       Collections.sort(list,test);

        // to store in new map
        Map<String,Integer> newNameAgeDataMap = new LinkedHashMap<>();

        // store  each entry in new map
        for(Map.Entry<String,Integer> map:list)
        {
          newNameAgeDataMap.put(map.getKey(),map.getValue());
        }

        // print the final result
        System.out.println(newNameAgeDataMap);
    }
}

