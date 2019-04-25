package com.test;

public class Test24_Sychronized implements Runnable {
    static int a = 0;

    public static synchronized void f() {
        a += 1;
        System.out.println(a);
    }

    @Override
    public void run() {
        this.f();
    }

    public static void main(String[] args) {
        Test24_Sychronized test24_sychronized = new Test24_Sychronized();
        Test24_Sychronized test24_sychronized1 = new Test24_Sychronized();
        Test24_Sychronized test24_sychronized2 = new Test24_Sychronized();
        Test24_Sychronized test24_sychronized3 = new Test24_Sychronized();
        Test24_Sychronized test24_sychronized4 = new Test24_Sychronized();
        Test24_Sychronized test24_sychronized5 = new Test24_Sychronized();
        Thread t1 = new Thread(test24_sychronized);
        Thread t2 = new Thread(test24_sychronized);
        Thread t3 = new Thread(test24_sychronized);
        Thread t5 = new Thread(test24_sychronized);
        Thread t6 = new Thread(test24_sychronized);
        Thread t4 = new Thread(test24_sychronized);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
