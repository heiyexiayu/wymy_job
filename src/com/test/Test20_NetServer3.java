package com.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Test20_NetServer3 extends JFrame implements ActionListener {
    JTextArea jta = null;
    JTextField jtf = null;
    JButton jb = null;
    JPanel jp1 = null;
    JScrollPane jsp = null;
    //信息发送给客户端
    PrintWriter pw = null;

    public static void main(String[] args) {
        new Test20_NetServer3();
    }

    public Test20_NetServer3() {
        jta = new JTextArea();
        jsp = new JScrollPane(jta);
        jtf = new JTextField(10);
        jb = new JButton("发送");
        jb.addActionListener(this);
        jp1 = new JPanel();
        jp1.add(jtf);
        jp1.add(jb);
        this.add(jsp, "Center");
        this.add(jp1, "South");
        this.setSize(300, 200);
        this.setVisible(true);
        this.setTitle("服务器");
        //监听
        try {
            ServerSocket ss = new ServerSocket(9988);
            //等待链接
            Socket s = ss.accept();
            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            BufferedReader br1 = new BufferedReader(isr);
            pw = new PrintWriter(s.getOutputStream(), true);
            //读取客户端发来的信息
            while (true) {
                String info = br1.readLine();
                if (info.length() != 0)
                    jta.append("客户端发送： " + info + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //用户按下 发送信息按钮
        if (e.getSource() == jb) {
            //把服务器的信息发送出去
            String info = jtf.getText();
            if (info.length() != 0)
                jta.append("服务器发送：" + info + "\r\n");
            pw.println(info);
            //发送出去后清空编辑框
            jtf.setText("");
        }
    }
}
