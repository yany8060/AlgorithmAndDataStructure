package com.yany.algorithms.sort;

import com.alibaba.fastjson.JSON;

/**
 * 冒泡排序
 * Created by yanyong on 2017/2/4.
 */
public class BubbleSort {

    public static void bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {

            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] < numbers[j + 1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
            }
        }
        System.out.println(JSON.toJSONString(numbers));

    }

    public static void main(String[] args) {
        int[] numbers = new int[]{4, 5, 7, 1, 1, 3};
        bubbleSort(numbers);
    }


}
