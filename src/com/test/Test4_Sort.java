package com.test;

import java.util.Arrays;

public class Test4_Sort {
    int temp = 0;

    void maopao(int[] S) {
        for (int i = 0; i < S.length - 1; i++)
            for (int j = 1; j < S.length - 1; j++)
                if (S[j] < S[j - 1]) {
                    temp = S[j];
                    S[j] = S[j - 1];
                    S[j - 1] = temp;
                }
    }

    void xuanze(int s[]) {
        int k;
        for (int i = 0; i < s.length - 1; i++) {
            k = i;
            for (int j = i + 1; j < s.length; j++)
                if (s[k] > s[j])
                    k = j;
            temp = s[i];
            s[i] = s[k];
            s[k] = temp;
        }
    }

    void charu(int s[]) {
        for (int i = 1; i < s.length; i++) {
            temp = s[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (temp < s[j])
                    s[j + 1] = s[j];
                else break;
            }
            s[j + 1] = temp;
        }
    }

    void kuaisu(int[] s, int low, int high) {
        int i = low;
        int j = high;
        int key = s[low];
        if (low < high) {
            while (i < j) {
                while (i < j && key <= s[j]) {
                    j--;
                }
                s[i] = s[j];
                while (i < j && key >= s[i]) {
                    i++;
                }
                s[j] = s[i];
                s[i] = key;
            }
            kuaisu(s, low, i - 1);
            kuaisu(s, i + 1, high);
        }
    }


    public static void main(String[] args) {
        int[] A = {2, 7, 4, 3, 1, 9};
        Test4_Sort mp = new Test4_Sort();
        mp.kuaisu(A, 0, 5);
//    for(int i=0;i<A.length;i++)
//        System.out.println(A[i]);
        System.out.println(Arrays.toString(A));
    }

}

