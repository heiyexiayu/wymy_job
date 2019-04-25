package com.test;

public class Test8_Runnable implements Runnable {
    int i = 0;

    public void run() {
        synchronized (this) {
            for (int j = 0; j < 5; j++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("j" + j);
                System.out.println(Thread.currentThread().getName() + " " + (i += 1));
            }
        }
    }

    public static void main(String[] args) {
        Test8_Runnable test8 = new Test8_Runnable();
        Thread t1 = new Thread(test8, "线程1");
        Thread t2 = new Thread(test8, "线程2");
        t1.start();
        t2.start();
    }
}
