package com.test;

import javax.swing.*;
import java.awt.*;

public class Test11_Awt extends JFrame {

    JButton jb1, jb2, jb3;

    public static void main(String[] args) {

        new Test11_Awt();
    }

    public Test11_Awt() {
        jb1 = new JButton("关于");
        jb1.setSize(50, 50);
        jb2 = new JButton("刘备");
        jb3 = new JButton("张飞");
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setTitle("布局管理器");
        this.setLocation(200, 200);
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

}
