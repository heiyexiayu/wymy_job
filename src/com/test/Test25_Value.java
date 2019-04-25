package com.test;

public class Test25_Value {
    static int a = 2;

    public static void f() {
        a += 1;
        System.out.println(a);
    }

    public static void main(String[] args) {

        new Test25_Value().f();
        new Test25_Value().f();
        System.out.println(a);
    }
}
