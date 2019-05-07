package com.arithmetic.sort;

import java.util.Arrays;
import java.util.Date;

/**
 * @Author WYMY
 * @Date 2019/4/24 12:33
 */
public class HeapSortTest {
    public static void sort(int []arr){
        //构建最大堆（初始化）从最后一个非叶子节点开始
        for(int i=(arr.length-1)/2;i>=0;i--){
            partAdjust(arr,i,arr.length);
        }
        //将最大值交换到末尾 并调整剩下成为最大堆
          for(int j=arr.length-1;j>=0;j--){
              swap(arr,0,j);
              partAdjust(arr,0,j);
          }

    }
    //局部调整 使父节点的值比左右节点大
    public static void partAdjust(int []arr,int i,int length){
        int temp=arr[i];
        //每次都跳到左节点
        for( int k=2 * i + 1;k<length;k=2*k+1){
            //选出左右节点较大的值 k<length-1的原因是不需要将排好的最后一个数加入调整范围
            if (k<length-1&&arr[k] <arr[ k+1]) {
                k++;
            }
            //如果子节点中的值比父节点大 将值赋给父节点 并且调整节点指向下一个左节点
            if(temp<arr[k]){
                arr[i]=arr[k];
                i=k;
            }
            //在最大堆的条件下 如果父节点值比子节点都大，就不需要再往下比较
            else break;
        }
        arr[i]=temp;

    }
    public static void swap(int[]arr,int a,int b){
        int temp =arr[a];
            arr[a]=arr[b];
            arr[b]=temp;
    }

    public static void main(String[] args) {
        int []arr1= {11,12,14,10,5,9,8,7,3,6,4};
        int arr[]=new int[100000];
        int j=0;
        for(int i=arr.length-1;i>=0;i--){
            arr[i]=j;
            j++;
        }
        sort(arr1);
        System.out.println(Arrays.toString(arr1));
//        System.out.println("----------");
//        System.out.println(new Date().getTime());
//        sort(arr);
//        System.out.println(new Date().getTime());
//        System.out.println(Arrays.toString(arr));
    }
}
