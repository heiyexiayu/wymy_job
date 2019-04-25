package com.test;

public class Test23_Static {
    static int a = 0;

    public static void f() {
        a += 1;
    }

    public static void main(String[] args) {
        Test23_Static.f();
        System.out.println(a);
    }
}
