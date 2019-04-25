package com.test;

public class Test5_List {
    Node1 node = null;

    /* 从头结点添加一个节点*/
    public void add(int data) {
        Node1 p = new Node1(data);
        p.next = node;
        node = p;
    }

    /* 在指定位置插入节点*/
    public void addIndex(int index, int data) {
        Node1 p = node;
        Node1 q = new Node1(data);
        while (index != 1) {
            p = p.next;
            index--;
        }
        q.next = p.next;
        p.next = q;
    }

    /*遍历输出所有节点数据*/
    public void display() {
        Node1 p = node;
        while (p != null) {
            p.show();
            p = p.next;
        }
        System.out.println();
    }

    /* 链表反向*/
    public void reverse() {
        Node1 p = node;
        Node1 q = null;
        Node1 pr = null;
        while (p != null) {
            pr = p.next;
            p.next = q;
            q = p;
            p = pr;
        }
        node = q;
    }

    public static void main(String[] args) {
        Test5_List t5 = new Test5_List();
        t5.add(1);
        t5.add(2);
        t5.add(3);
        t5.add(4);
        t5.add(5);
        t5.reverse();


    }
}/* 创建一个节点类*/

class Node1 {
    Node1 next;
    int data;

    public Node1(int data) {
        this.data = data;
    }

    public void show() {
        System.out.print(data + " ");
    }
}
