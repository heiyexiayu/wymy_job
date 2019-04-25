package com.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test16_SwingTwo extends JFrame implements ActionListener {
    int i;
    JButton jb = new JButton("创建按钮");
    JPanel jp = new JPanel();

    public Test16_SwingTwo() {
        this.setTitle("流式布局");
        jp.setLayout(new FlowLayout());
        jp.add(jb);
        jb.addActionListener(this);
        this.add(jp);
        this.setBounds(300, 250, 300, 200);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton jbi = new JButton("按钮" + (++i));
        jp.add(jbi);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Test16_SwingTwo tst = new Test16_SwingTwo();
    }
}
