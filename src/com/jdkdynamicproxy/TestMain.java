package com.jdkdynamicproxy;

/**
 * @Author create by  huarong
 * @Date ${Date} ${Time}
 */
public class TestMain {
   public static void main(String[] args) {
        Sub sub= (Sub) new JDKProxy(new SubImpl()).getProxy();
          sub.printy();
          System.out.println(sub.sayHello("张三"));
    }
}
