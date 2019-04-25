package com.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Test13_Thread implements Runnable {
    int i = 0;

    public synchronized void run() {
        for (int j = 0; j < 3; j++) {
            i += 1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(i);
    }

    public static void main(String[] args) {
//        Test13_Thread  ru=new Test13_Thread() ;
//        Thread t1=new Thread(ru);
//        Thread t2=new Thread (ru);
//        t1.start() ;
//        t2.start() ;

        ThreadTest tt = new ThreadTest(3);
        FutureTask<Integer> result = new <Integer>FutureTask(tt);
        FutureTask<Integer> result1 = new <Integer>FutureTask(tt);
        FutureTask<Integer> result2 = new <Integer>FutureTask(tt);
        Thread tt1 = new Thread(result, "1hao   ");
        Thread tt2 = new Thread(result1, "2hao   ");
        Thread tt3 = new Thread(result2, "3hao   ");
        tt1.setPriority(1);
        tt2.setPriority(1);
        tt3.setPriority(10);
        tt1.start();
        tt2.start();
        tt3.start();
//            try {
//          Integer ss=  result.get();
//          System.out.println(ss);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }
}

class ThreadTest implements Callable<Integer> {
    int sum;
    int sum1;

    public ThreadTest(int sum) {
        this.sum = sum;
    }

    public Integer call() {
        System.out.println(Thread.currentThread().getName());
        sum += 2;
        for (int i = 0; i < 3; i++) {
            sum1 += 1;
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
            System.out.println(sum1);

        }
        return sum;
    }
}
