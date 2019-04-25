package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test14_ThreadPool {
    public static void main(String[] args) {
        new Test14_ThreadPool().te();
    }

    public void te() {
        ExecutorService es = Executors.newCachedThreadPool();

        for (int i = 0; i < 1222; i++)
            es.execute(new Runnable() {
                @Override
                public void run() {
                    this.getClass();
                    System.out.println(Thread.currentThread());
                }
            });
        es.shutdown();
    }

}
