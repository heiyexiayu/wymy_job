package com.test;

import java.util.Date;

public class TestNul {
    public static void main(String[] args) {
        int i = 0;
        Date date = new Date();
        //if( date!=""){  类型不匹配报错
        if ("" == null) {
            System.out.println("Yes");
        } else {
            System.out.println("No");

        }
        System.out.println(31>>1);
    }
}
