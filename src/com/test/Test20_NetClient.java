package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Test20_NetClient {
    public static void main(String[] args) {
        new Test20_NetClient();
    }

    public Test20_NetClient() {
        try {
            Socket s = new Socket("0.0.0.0", 9999);
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            pw.println("我是客户端，你好");
            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String resp = br.readLine();
            System.out.println("客户端收到回复" + resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
