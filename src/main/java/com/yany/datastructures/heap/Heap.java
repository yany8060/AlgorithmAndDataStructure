package com.yany.datastructures.heap;

import com.alibaba.fastjson.JSON;

/**
 * @author yanyong on 2019/11/29
 */
public class Heap {
    public static void main(String[] args) {
        Heap heap = new Heap(10);

        int a[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        heap.heapify(a, 10, 1);
        System.out.println(JSON.toJSONString(a));
    }

    private int[] a;
    private int n;
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1]; // +1 数组第一个元素为空
        n = capacity;
        count = 0;
    }


    public void insert(int data) {
        if (count >= n) {
            return;// 没有空间了
        }
        count++;
        a[count] = data;
        int i = count;
        // 堆化
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            int tmp = a[i];
            a[i] = a[i / 2];
            a[i / 2] = tmp;
            i = i / 2;
        }
    }

    /**
     * 删除最大值
     */
    public void removeMax() {
        if (count == 0) {
            return;
        }
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    /**
     * 堆化
     *
     * @param a
     * @param n
     * @param i
     */
    private void heapify(int[] a, int n, int i) {
        while (true) {
            // 最大值位置
            int maxPos = i;

            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            // 与右子节点（i * 2 + 1）比较，获取最大值位置
            if ((i * 2 + 1) <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            int temp = a[i];
            a[i] = a[maxPos];
            a[maxPos] = temp;
            i = maxPos;
        }
    }


}
