package com.yany.algorithms.sort;

import com.alibaba.fastjson.JSON;

/**
 * Created by yanyong on 2017/2/4.
 */
public class QuickSort {
    public static void quickSort(int[] numbers, int low, int high) {
        if (low < high) {
            int middle = getMiddle(numbers, low, high);
            quickSort(numbers, low, middle);
            quickSort(numbers, middle + 1, high);
        }

    }

    public static int getMiddle(int[] numbers, int low, int high) {
        int middle = numbers[low];
        while (low < high) {
            while (low < high && numbers[high] >= middle) {
                high--;
            }
            numbers[low] = numbers[high];
            while (low < high && numbers[low] <= middle) {
                low++;
            }
            numbers[high] = numbers[low];
        }
        numbers[low] = middle;
        return high;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{5, 2, 6, 7, 1, 3, 2, 1, 15, 7};
        int a = numbers[0];
        numbers[0] = 1;
        System.out.println(a);
        quickSort(numbers, 0, numbers.length - 1);
        System.out.println(JSON.toJSONString(numbers));

    }

}
