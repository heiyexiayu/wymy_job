package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<A> list = new ArrayList<A>();
        A a1 = new A(1, "a1");
        A a2 = new A(2, "a2");
        A a3 = new A(3, "a3");
        A a4 = new A(4, "a4");
        A a5 = new A(5, "a5");
        A[] arr1 = new A[5];
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        list.toArray(arr1);
        list.remove(a2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(list.size());
    }

}

class A {
    int id;
    String name;

    public A(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean equals(Object obj) {
        return false;
    }

}