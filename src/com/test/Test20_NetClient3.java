package com.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Test20_NetClient3 extends JFrame implements ActionListener {
    JTextArea jta = null;
    JTextField jtf = null;
    JButton jb = null;
    JPanel jp1 = null;
    JScrollPane jsp = null;
    PrintWriter pw = null;

    public static void main(String[] args) {
        new Test20_NetClient3();
    }

    public Test20_NetClient3() {
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
        this.setTitle("客户端");
        try {
            Socket s = new Socket("0.0.0.0", 9988);
            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            pw = new PrintWriter(s.getOutputStream(), true);
            while (true) {
                //不停地读
                String info = br.readLine();
                if (info.length() != 0)
                    jta.append("服务器发送：" + info + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb) {
            String info = jtf.getText();
            if (info.length() != 0)
                jta.append("客户端发送： " + info + "\r\n");
            pw.println(info);
            jtf.setText("");
        }
    }
}
