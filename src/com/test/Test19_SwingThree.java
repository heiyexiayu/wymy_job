package com.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Test19_SwingThree extends JFrame {
    MyPanel1 mp1 = null;

    public Test19_SwingThree() {
        mp1 = new MyPanel1();
        this.add(mp1);
        this.addKeyListener(mp1);
        this.setSize(300, 200);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Test19_SwingThree();
    }
}

class MyPanel1 extends Panel implements KeyListener {
    public int x = 10;
    int y = 10;

    public MyPanel1() {
        setBackground(Color.YELLOW);

    }

    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 10, 10);

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            y += 2;
        else if (e.getKeyCode() == KeyEvent.VK_UP)
            y -= 2;
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
            x -= 2;
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            x += 2;
        this.repaint();
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }
}
