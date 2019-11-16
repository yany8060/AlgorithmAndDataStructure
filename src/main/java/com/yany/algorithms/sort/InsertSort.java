package com.yany.algorithms.sort;

import java.util.Arrays;

/**
 * Created by yanyong on 2017/2/4.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {2, 7, 8, 3, 1, 0, 6, 9, 0, 5, 4};

        insertSort(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }


    // 插入排序，a表示数组，n表示数组大小
    public static void insertSort(int[] a, int n) {
        if (n <= 1) return;

        for(int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;

            // 查找要插入的位置并移动数据
            for(;j >= 0; j--) {
                if(a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }

            /**
             * 另一种查找插入位置
             while(j >=0 && a[j] > value) {
             a[j + 1] = a[j];
             j--;
             }
             */

            // 由于执行了j-- 所以要+1
            a[j + 1] = value;
        }
    }


}
