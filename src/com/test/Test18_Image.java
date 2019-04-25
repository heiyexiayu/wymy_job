package com.test;

import javax.swing.*;
import java.awt.*;

public class Test18_Image extends JFrame {
    MyPanel mp;
    JButton jb;

    public Test18_Image() {
        jb = new JButton("11111");
        jb.setBounds(80, 80, 30, 10);
        mp = new MyPanel();
        mp.add(jb);
        this.add(mp);
        this.setSize(300, 200);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Test18_Image();
    }
}

class MyPanel extends Panel {


    public void paint(Graphics g) {
        super.paint(g);
        Image im = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/Kaola.jpg"));
        g.drawImage(im, 10, 10, 100, 100, this);
    }
}