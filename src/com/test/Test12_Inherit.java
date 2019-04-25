package com.test;

public class Test12_Inherit extends Father {
    int a = 2;

    void f1() {

        int b = 2;
        System.out.println("儿子" + super.a);
    }

    public static void main(String[] args) {
        Father son = new Father();
        System.out.println(son.a);
        Test12_Inherit son2 = new Test12_Inherit();
        System.out.println(son2.a);
        son2.f1();
    }
}

class Father {
    int a = 1;

    void f1() {
        int b = 2;

        System.out.println("父亲");
    }
}