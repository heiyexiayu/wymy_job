package com.arithmetic.sort;

import java.util.Arrays;

/**
 * @Author WYMY
 * @Date 2019/4/27 15:25
 */
//希尔排序
public class ShellSort {

    public static void shellSort(int[] arr) {
        //步长从arr.length/2   --> 1      时间复杂度log2n
        for (int d = arr.length / 2; d > 0; d = d / 2) {
            //时间复杂度O(n)
            for (int i = d; i < arr.length; i++) {
                int j = 0;
                //时间复杂度O(1)
                for (j = i; j >= d; j = j - d) {
                    if (arr[j] < arr[j - d]) {
                        int temp = arr[j];
                        arr[j] = arr[j - d];
                        arr[j - d] = temp;
                    } else
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 9, 9, 8, 2, 4, 3, 7, 1, 2, 0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
