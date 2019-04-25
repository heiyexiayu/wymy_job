package com.test;

public class DynamicPlanning {
    public static void dynamic(int[] coinValues, int value) {
        int[] count = new int[100];
        count[0] = 0;
        for (int i = 1; i <= value; i++) {
            int min = i;
            for (int j = 0; j < coinValues.length; j++) {
                if (coinValues[j] <= i) {
                    int temp = count[i - coinValues[j]] + 1;
                    if (temp < min)
                        min = temp;
                }
            }
            count[i] = min;
        }
        System.out.println("面值为 " + (value) + " 的最小硬币数 : "
                + count[value]);
    }

    public static void main(String[] args) {
        int[] aa = {1, 2, 4};
        dynamic(aa, 7);
    }
}

