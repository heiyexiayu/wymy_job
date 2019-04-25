package com.list;

/**
 * @Author create by  huarong
 * @Date ${Date} ${Time}
 */
public class ListTest {
    Node node = null;

    // 从头添加一个节点
    public void add(int data) {
        Node p = new Node(data);
        p.next = node;
        node = p;
    }

    // 在指定位置插入节点
    public void addIndex(int index, int data) {
        Node p = node;
        Node q = new Node(data);
        while (index != 1) {
            p = p.next;
            index--;
        }
        q.next = p.next;
        p.next = q;
    }

    //遍历输出所有节点数据
    public void showAll() {
        Node p = node;
        while (p != null) {
            p.showData();
            p = p.next;
        }
        System.out.println();
    }

    /**链表反向*/
    public void reverse() {
        Node p = node;
        Node q = null;
        Node pr = null;
        while (p != null) {
            pr = p.next;
            p.next = q;
            q = p;
            p = pr;
        }
        node = q;
    }
    public static void main(String[] args) {
        ListTest listTest = new ListTest();
        int i = 10;
        while (i > 0) {
            listTest.add(i);
            i--;
        }
        System.out.println("before:");
        listTest.showAll();
        listTest.reverse();
        System.out.println("after:");
        listTest.showAll();
    }
}
