package com.test;

public class TestException {
    public void testException(int i) {
        if (i > 5) {
            throw new MyException(" 越界啦");
        } else {
            System.out.println("NO Problem!");
        }
    }

    public static void main(String[] args) {
        new TestException().testException(7);
    }
}

class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }
}
