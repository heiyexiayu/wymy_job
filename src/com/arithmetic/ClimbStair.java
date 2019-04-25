package com.arithmetic;

/**
 * 2018年9月12日20:53:13
 * 爬楼梯可选择1,2,3级阶梯，共有m层
 */
public class ClimbStair {
    int sum;

    public int climb(int m) {
        if (m == 1) return sum + 1;
        else if (m == 2) return sum + 2;
        else if (m == 3) return sum + 4;
        else return climb(m - 1) + climb(m - 2) + climb(m - 3);
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStair().climb(4));
    }
}
