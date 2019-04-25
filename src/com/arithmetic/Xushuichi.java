package com.arithmetic;

import java.util.Random;

public class Xushuichi {
    public static void main(String[] args) {
        int n = 5;
        int m = 4;
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int N[] = new int[n];
        for (int i = 0; i < n; i++)
            System.out.print((N[i] = i) + "  ");
        System.out.println();
        for (int j = 0; j < 10000000; j++) {
            int l[] = xushuichi(N, m);
            for (int q = 0; q < m; q++) {
                if (l[q] == 0)
                    one++;
                if (l[q] == 1)
                    two++;
                if (l[q] == 2)
                    three++;
                if (l[q] == 3)
                    four++;
                if (l[q] == 4)
                    five++;

            }
        }
        System.out.println("0 " + one + "  1 " + two + "   2 " + three + "   3 " + four + "   4 " + five);
        // for (int i=0;i<10 ;i++)
        // System.out.print(l[i]+"  ");
    }

    public static int[] xushuichi(int k[], int m) {
        int b[] = new int[m];
        if (k.length <= m)
            return new int[0];
        else if (k.length > m) {
            for (int j = 0; j < k.length; j++) {
                if (j < m)
                    b[j] = k[j];
                else if (j >= m) {
                    int r = new Random().nextInt(j + 1);
                    if (r < m)
                        b[r] = k[j];
                }
            }
        }
        return b;
    }
}