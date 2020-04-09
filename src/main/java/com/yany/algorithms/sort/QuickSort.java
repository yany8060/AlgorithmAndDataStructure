package com.yany.algorithms.sort;

import com.alibaba.fastjson.JSON;

/**
 * Created by yanyong on 2017/2/4.
 */
public class QuickSort {
    public static void quickSort(int[] numbers, int low, int high) {
        if (low < high) {
            int middle = partition2(numbers, low, high);
            quickSort(numbers, low, middle - 1);
            quickSort(numbers, middle + 1, high);
        }

    }

    public static int partition3(int[] a, int l, int r) {
        int pivot = a[r];
        while (l < r) {
            while (pivot >= a[l] && l < r) {
                l++;
            }
            a[r] = a[l];
            while (pivot <= a[r] && l < r) {
                r--;
            }
            a[l] = a[r];
        }
        a[r] = pivot;
        return r;
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

    public static int partition2(int[] a, int l, int r) {
        int pivot = a[r];

        int i = l;
        for (int j = l; j < r; j++) {
            System.out.println("aaa");
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    swap(a, i, j);
                    i++;
                }
            }
        }
        swap(a, i, r);
        return i;
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;

        int q = partition(a, p, r); // 获取分区点
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{5, 2, 6, 6, 1, 3, 2, 1, 15, 7};
        int a = numbers[0];
        numbers[0] = 1;
        System.out.println(a);
        quickSort(numbers, 0, numbers.length - 1);

        //quickSortInternally(numbers, 0, numbers.length - 1);
        System.out.println(JSON.toJSONString(numbers));
    }

}
