package com.arithmetic.sort;

import java.util.Arrays;

/**
 * @Author WYMY
 * @Date 2019/4/27 16:10
 */
//归并排序
public class MergeSort {
    //归并
    public static void merge(int[] arr, int low, int middle, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = middle + 1;
        int index = 0;
        while (i <= middle && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[index] = arr[i];
                i++;
                index++;
            } else {
                temp[index] = arr[j];
                j++;
                index++;
            }
        }
        while (i <= middle) {
            temp[index] = arr[i];
            index++;
            i++;
        }
        while (j <= high) {
            temp[index] = arr[j];
            index++;
            j++;
        }
        for (int k = 0; k < temp.length; k++) {
            arr[low + k] = temp[k];
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        int middle = (high + low) / 2;
        if (low < high) {
            //前半部分
            mergeSort(arr, low, middle);
            //后半部分
            mergeSort(arr, middle + 1, high);
            //对排好序的进行归并
            merge(arr, low, middle, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 8, 1, 2, 4};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, 7);
        System.out.println(Arrays.toString(arr));
    }
}
