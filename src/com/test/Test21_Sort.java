package com.test;

import java.util.Arrays;
import java.util.Scanner;

public class Test21_Sort {
    static int[] arr = new int[5];

    //插入
    public static void sort2(int arrp[]) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--)
                if (arr[j] > temp)
                    arr[j + 1] = arr[j];
                else break;
            arr[j + 1] = temp;
        }
    }
    //插入
    public static void insert(int [] objects){
        for(int i=1;i<objects.length;i++){
            int j=0;
            int temp =objects[i];//object[i] 在过程中可能会变化 需要一个变量暂时存储其信息
            for( j=i-1;j>=0;j--){
                if(objects[j]>temp){
                    objects[j+1]=objects[j];
                }else break;
            }
            objects[j+1]=temp;
        }
    }





    public static  void diii(int []arr){
        for(int i=1;i<arr.length;i++){
            int temp =arr[i];
            int j=0;
            for( j =i-1;j>=0;j--){
                if(arr[j]>temp){
                    arr[j+1]=arr[j];
                }else break;
            }
            arr[j+1]=temp;
        }
    }

    //选择排序
    public static void sort1(int[] arr) {
        int temp;
        int k;
        for (int i = 0; i < arr.length; i++) {
            k = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[k] > arr[j])
                    k = j;
            }
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
    }
//kuaisu
    public static void quick1(int arr[] ,int left,int right){
        int l=left;
        int h=right;
        if(l<h){
            int temp=arr[l];
            while(l<h){
                while(l<h&&arr[h]>=temp){
                    h--;
                }
                arr[l]=arr[h];
                while(l<h&&arr[l]<=temp){
                    l++;
                }
                arr[h]=arr[l];
                arr[l]=temp;
            }
            quick1(arr,left,l-1);
            quick1(arr,l+1,right);
        }
    }
    //kuai
    public static void sort4(int low, int high, int[] arr) {
        int i = low;
        int j = high;
        if (low < high) {
            int temp = arr[i];
            while (i < j) {
                while (i < j && temp <= arr[j]) {
                    j--;
                }
                arr[i] = arr[j];
                while (i < j && temp >= arr[i]) {
                    i++;
                }
                arr[j] = arr[i];
                arr[i] = temp;
            }
            sort4(low, i - 1, arr);
            sort4(i + 1, high, arr);
        }
    }

    //快速 错误的排序      46214   回报越界
    public static void sort3(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int key = arr[i];//原因  对最后一个数操作时 i已经为arr[].length+1 故越界  需要放到if中
        if (low < high) {
            while (i < j) {
                while (i < j && key <= arr[j]) {
                    j--;
                }
                arr[i] = arr[j];
                while (i < j && key >= arr[i]) {
                    i++;
                }
                arr[j] = arr[i];
                arr[i] = key;
            }
            sort3(arr, low, i - 1);
            sort3(arr, i + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
       // Arrays.sort(arr);
//        diii(arr);
         quick1(arr,2,4);
        // sort3(arr,0,4);
        //sort4(0, 4, arr);
        System.out.println(Arrays.toString(arr));
//        Arrays.sort(arr);用的是快速排序的算法
//        System.out.println(Arrays.toString(arr));
    }
}
