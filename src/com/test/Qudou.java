package com.test;

import java.util.Scanner;

public class Qudou {

    Scanner sc = new Scanner(System.in);
    String s = sc.next();

    public void qudou() {
        System.out.println(s);
        if (s.equals("Yes")) {
            System.out.println("稍等一下");
            try {
                Thread.sleep(3000);
                System.out.println("快好了");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("祛痘成功");
        }
        System.out.println("拜拜");
    }

    public static void main(String[] args) {
        System.out.println("你要祛痘吗？");
        new Qudou().qudou();
    }
}
