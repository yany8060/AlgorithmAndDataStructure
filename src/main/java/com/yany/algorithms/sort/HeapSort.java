package com.yany.algorithms.sort;

/**
 * @author yanyong on 2020/3/8
 */
public class HeapSort {

    public static void sort(int[] nums) {
        // 1.构建大顶堆
        for (int i = nums.length / 2 - 1; i >= 0; i++) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(nums, i, nums.length);
        }

        // 2.调整堆结构+交换堆顶元素与末尾元素
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            // 重新对堆进行调整
            adjustHeap(nums, 0, i);
        }
    }

    public static void adjustHeap(int[] nums, int i, int length) {
        int tmp = nums[i];

        // 从i结点的左子结点开始，也就是2i+1处开始
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {

            // 如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && nums[k] < nums[k + 1]) {
                k++;
            }
            if (nums[k] > tmp) {
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }
        nums[i] = tmp;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
