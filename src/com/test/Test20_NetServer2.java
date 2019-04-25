/**
 * 功能： 服务器端 在9999端口监听
 * 可以通过控制台，
 */
package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Test20_NetServer2 {
    public static void main(String[] args) {
        new Test20_NetServer2();
    }

    public Test20_NetServer2() {
        try {
            ServerSocket ss = new ServerSocket(9999);
            Socket s = ss.accept();
            //正在监听
            System.out.println("服务器在9999监听");
            //先接受客户端
            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            //写的流
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            InputStreamReader isr2 = new InputStreamReader(System.in);
            BufferedReader br2 = new BufferedReader(isr2);
            while (true) {
                String ifcc = br.readLine();
                System.out.println("客户端发来：" + ifcc);
                //判断客户端是否要结束对话
                if (ifcc.equals("再见")) {
                    System.out.println("对话结束");
                    s.close();
                    break;
                }
                //从控制台输入信息
                System.out.println("输入你希望对客户端说的话");
                String resp = br2.readLine();
                pw.println(resp);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
