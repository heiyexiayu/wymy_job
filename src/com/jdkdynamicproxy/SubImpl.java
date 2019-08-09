package com.jdkdynamicproxy;

/**
 * @Author create by  huarong
 * @Date ${Date} ${Time}
 */
public class SubImpl implements Sub {
    @Override
    public void printy() {
        System.out.println("真实的方法");
    }

    @Override
    public String sayHello(String name) {
        System.out.println();
        return name + "  say hello";
    }
}
