package com.test;

/**
 * 2018年9月12日22:35:51
 * 剪绳子，求最大乘积
 * 至少简一刀
 */
public class CutRope {
    public int cut(int l) {
        if (l <= 1) {
            return 0;
        } else if (l == 2)
            return 2;
        else if (l == 3)
            return 2;
        //尽量剪成3米的
        int time3 = l / 3;
        int time2 = 0;
        if (l - time3 * 3 == 1) {
            time3 -= 1;
        }
        time2 = (l - time3 * 3) / 2;
        return (int) (Math.pow(3, time3) * Math.pow(2, time2));
    }

    public static void main(String[] args) {
        System.out.println(new CutRope().cut(10));

    }
}
