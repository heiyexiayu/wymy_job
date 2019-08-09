package com.arithmetic;

import java.util.Date;

/**
 * @Author WYMY
 * @Date 2019/4/25 16:01
 */
//钢条切割
public class CutLine {
    //普通递归
    public static int cut(int[] p, int n) {
        if (n == 0) {
            return 0;
        }
        int q = -1;
        for (int i = 1; i <= n && i <= p.length; i++) {
            q = Math.max(q, p[i - 1] + cut(p, n - i));
        }
        return q;
    }

    //备忘录递归
    public static int cutmem(int[] p, int n) {
        int[] r = new int[p.length + 1];
        return cut1(p, n, r);
    }

    public static int cut1(int[] p, int n, int[] r) {
        if (r[n] > 0) {
            return r[n];
        }
        if (n == 0) {
            return 0;
        }
        int q = -1;
        for (int i = 1; i <= n && i <= p.length; i++) {
            q = Math.max(q, p[i - 1] + cut1(p, n - i, r));
        }
        r[n] = q;
        return r[n];
    }

    //递推
    public static int cut3(int[] p, int n) {
        int[] r = new int[p.length + 1];
        int q = -1;
        for (int i = 1; i <= n && i <= p.length; i++) {
            for (int j = 1; j <= i; j++) {
                q = Math.max(q, p[j - 1] + r[i - j]);
            }
            r[i] = q;
        }
        return r[n];
    }

    public static void main(String[] args) {
//        int []p={1,5,8,9,10,17,17,20,24,30};
        int[] p = new int[10000];
        for (int i = 0; i < p.length; i++) {
            p[i] = i + 1;
        }
        System.out.println(new Date().getTime());
        System.out.println(cut3(p, 5000));
//        System.out.println(new Date().getTime());
//        System.out.println( cut(p,10));
        System.out.println(new Date().getTime());
        System.out.println(cutmem(p, 5000));
        System.out.println(new Date().getTime());
    }
}
