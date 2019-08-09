package com.list;

/**
 * @Author create by  huarong
 * @Date ${Date} ${Time}
 */
public class Node {
    private int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public void showData() {
        System.out.print(data + " ");
    }
}
