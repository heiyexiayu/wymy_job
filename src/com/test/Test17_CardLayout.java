package com.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Test17_CardLayout extends JFrame implements ActionListener {
    JButton jb1 = new JButton("下一个");
    //    JButton jb2=new JButton("上一个");
    JPanel jp = new JPanel();
    CardLayout cl = new CardLayout();

    public Test17_CardLayout() {

        this.setTitle("卡片布局");
        this.setLayout(null);
        jb1.setBounds(120, 40, 100, 20);
//        jb2.setBounds(120,70,100,20);
        this.add(jb1);
//        this.add(jb2);
        jb1.addActionListener(this);
//        jb2.addActionListener(this) ;
        jp.setBounds(10, 40, 100, 100);
        jp.setLayout(cl);
        for (int i = 0; i < 50; i++) {
            JButton jb = new JButton(i + "等奖");
            jp.add(jb, "" + i);
        }
        this.add(jp);
        this.setBounds(200, 200, 300, 220);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int i = new Random().nextInt(50);
        cl.show(jp, "" + i);

    }

    public static void main(String[] args) {
        Test17_CardLayout tcl = new Test17_CardLayout();
    }
}
