package com.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test15_SwingOne extends JFrame implements ActionListener {
    JButton jb = new JButton("1");
    JButton jb1 = new JButton("2");
    JPanel jp = new JPanel();
    int i = 0;
    int j = 0;

    public Test15_SwingOne() {
        this.setTitle("按钮");
        jp.add(jb);
        jp.add(jb1);
        this.add(jp);
        jb.addActionListener(this);
        jb1.addActionListener(this);
        this.setBounds(300, 250, 300, 200);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb)
            this.jb.setText("按钮按了" + (++i) + "次");
        else
            this.jb1.setText("按钮按了" + (++j) + "次");
    }

    public static void main(String[] args) {
        Test15_SwingOne tso = new Test15_SwingOne();
    }

}
