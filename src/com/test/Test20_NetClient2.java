package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Test20_NetClient2 {
    public static void main(String[] args) {
        new Test20_NetClient2();
    }

    public Test20_NetClient2() {
        try {
            Socket s = new Socket("0.0.0.0", 9999);
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            InputStreamReader isr2 = new InputStreamReader(s.getInputStream());
            BufferedReader br2 = new BufferedReader(isr2);
            while (true) {
                System.out.println("请输入你想对服务器想说的话");
                //从控制台输入
                String info = br.readLine();
                //发送给服务器
                pw.println(info);
                //判断客户端是否要结束对话2
                if (info.equals("再见")) {
                    System.out.println("对话结束");
                    s.close();
                    break;
                }
                //接受从服务器来的消息
                String resp = br2.readLine();
                System.out.println("服务器说 ：" + resp);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
