package com.test;

public class Test2 {
    public boolean f(Object o) {
        if (o == "a") {
            return true;
        } else {
            if (o == "b")
                return true;
        }

        return false;

    }

    public static void main(String[] args) {
        Test2 t2 = new Test2();
        System.out.println(t2.f("c"));
    }
}
