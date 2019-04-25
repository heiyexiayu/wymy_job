package com.test;

public class Test7_Thread extends Thread {
    int i = 0;
    Object o = new Object();

    public synchronized void run() {
        for (int j = 0; j < 3; j++)
            System.out.println(Thread.currentThread().getName() + "  " + (i += 1));
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("end");
        }
    }

    public static void main(String[] args) {
        Test7_Thread test7 = new Test7_Thread();
        Thread t1 = new Thread(test7, "线程1");
        Thread t2 = new Thread(test7, "线程2");
        t1.start();
        t2.start();
    }
}
