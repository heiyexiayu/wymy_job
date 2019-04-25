package com.test;

import java.util.ArrayList;
import java.util.Iterator;

public class Test6_Iterator {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);
        Iterator it = al.iterator();
        while (it.hasNext()) {
            if (it.next().equals(2)) {
                it.remove();
                System.out.println(it.next());
            }
        }
        for (int i = 0; i < al.size(); i++)
            System.out.print(al.get(i) + " ");
    }
}
