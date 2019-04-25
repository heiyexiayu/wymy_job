package com.test;

import java.util.HashMap;
import java.util.Map;

public class Test3 {
    public static void main(String[] args) {
        String aa[] = new String[10];
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(5, "e");
        map.put(2, "f");
        map.put(3, "c");
        map.put(4, "d");

        /**  String v1=map.get(2);
         int s=map.size() ;
         Collection<String>  v2= map.values();
         ArrayList al=new ArrayList(v2);
         al.toArray(aa) ;
         System.out.println(Arrays.toString(aa) );
         System.out.println(v1+s);**/
        //  for(int key:map.keySet() )
        //    System.out.print (map.get(key)+" ");
        for (Map.Entry<Integer, String> e : map.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        for (String s : map.values())
            System.out.print(s + " ");

    }
}
