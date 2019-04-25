package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a E");
        Date nowDay = new Date();
        System.out.println("当前时间 ：" + simpleDateFormat.format(nowDay));
        if (0 == 1) {
        }
        System.out.println("111");

    }
}
