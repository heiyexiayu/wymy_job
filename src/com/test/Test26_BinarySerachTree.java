package com.test;

/**
 * 2018年9月2日20:33:37
 */
public class Test26_BinarySerachTree {
    public MyNode init() {
        MyNode K = new MyNode(26, null, null);
        MyNode J = new MyNode(20, null, null);
        MyNode I = new MyNode(16, null, null);
        MyNode H = new MyNode(11, null, null);
        MyNode G = new MyNode(5, null, null);
        MyNode F = new MyNode(22, J, K);
        MyNode E = new MyNode(14, null, I);
        MyNode D = new MyNode(8, G, H);
        MyNode C = new MyNode(19, E, F);
        MyNode B = new MyNode(2, null, D);
        MyNode A = new MyNode(13, B, C);
        return A;   //返回根节点
    }

    public static void main(String[] args) {
        MyNode myNode = new Test26_BinarySerachTree().init();
//        System.out.println( );
        // myNode.insert(23,myNode);
        // System.out.println(myNode.find(23 ,myNode));
        myNode.preorder(myNode);
    }
}

class MyNode {
    private int key;
    private MyNode LeftMyNode;
    private MyNode RightMyNode;

    public MyNode(int key, MyNode LeftMyNode, MyNode RightMyNode) {
        this.key = key;
        this.LeftMyNode = LeftMyNode;
        this.RightMyNode = RightMyNode;
    }

    //查询
    public MyNode find(int key, MyNode root) {
        MyNode node = root;
        while (node != null) {
            if (key == node.key) {
                //查到的话就打印这个节点的key。然后返回这个node
                System.out.println(node.key);
                return node;
            } else if (key > node.key) {
                node = node.RightMyNode;
            } else if (key < node.key) {
                node = node.LeftMyNode;
            }
        }
        return null;
    }

    //插入
    public void insert(int key, MyNode root) {
        MyNode node = root;
        while (true) {
            if (key > node.key) {
                if (node.RightMyNode != null)
                    node = node.RightMyNode;
                else {
                    MyNode my = new MyNode(key, null, null);
                    node.setRightMyNode(my);
                    break;
                }
            } else {
                if (node.LeftMyNode != null)
                    node = node.LeftMyNode;
                else {
                    MyNode my = new MyNode(key, null, null);
                    node.setLeftMyNode(my);
                    break;
                }
            }
        }
    }

    //前序遍历
    public void preorder(MyNode Node) {
        if (Node != null) {
            System.out.print(Node.key + " ");
            preorder(Node.LeftMyNode);
            preorder(Node.RightMyNode);

        }
    }

    //中序遍历
    public void order(MyNode Node) {
        if (Node != null) {
            order(Node.LeftMyNode);
            System.out.println(Node.key + "");
            order(Node.RightMyNode);
        }
    }

    //后续遍历
    public void afterorder(MyNode Node) {
        if (Node != null) {
            afterorder(Node.LeftMyNode);
            afterorder(Node.RightMyNode);
            System.out.print(Node.key + " ");
        }
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setLeftMyNode(MyNode leftMyNode) {
        LeftMyNode = leftMyNode;
    }

    public void setRightMyNode(MyNode rightMyNode) {
        RightMyNode = rightMyNode;
    }

    public int getKey() {
        return key;
    }

    public MyNode getLeftMyNode() {
        return LeftMyNode;
    }

    public MyNode getRighter() {
        return RightMyNode;
    }
}