package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Test20_NetServer {
    public static void main(String[] args) {
        new Test20_NetServer();
    }

    public Test20_NetServer() {
        try {
            //在9999号监听
            ServerSocket ss = new ServerSocket(9999);
            System.out.println("我是服务器");
            Socket s = ss.accept();
            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String info = br.readLine();
            System.out.println("服务器收到" + info);

            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            pw.println("我是服务器你好啊");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
