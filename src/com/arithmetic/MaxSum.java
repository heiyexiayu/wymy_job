package com.arithmetic;

//求最大子序列
public class MaxSum {

    public static int f(int [] arr){
        int max=0;
        for(int i=0;i<arr.length;i++){
            int num=0;
            for(int j=i;j<arr.length;j++){
                 num+=arr[j];
                 if(num>max){
                     max=num;
                 }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int []arr={0,-1,-5,-2,-3,-4,-7,-8,-9};
         System.out.println(f(arr));
    }
}
