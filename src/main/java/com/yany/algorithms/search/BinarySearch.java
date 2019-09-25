package com.yany.algorithms.search;

/**
 * 【二分查找要求】：1.必须采用顺序存储结构 2.必须按关键字大小有序排列。
 * <p>
 * Created by yanyong on 2017/2/20.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] src = new int[]{1, 3, 5, 7, 8, 9};
        System.out.println(binarySearch(src, 3));
//        System.out.println(binarySearch(src, 4, 0, src.length - 1));

    }

    /**
     * @param srcArray 有序数组
     * @param des      查找元素
     */
    public static int binarySearch(int[] srcArray, int des) {
        int low = 0;
        int high = srcArray.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (des == srcArray[middle]) {
                return middle;
            } else if (des > srcArray[middle]) {
                low = middle + 1;
            } else if (des < srcArray[middle]) {
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     *
     * @param srcArray
     * @param data
     * @param beginIndex
     * @param endIndex
     * @return
     */
    public static int binarySearch(int[] srcArray, int data, int beginIndex, int endIndex) {
        int middle = (beginIndex + endIndex) / 2;
        if (data < srcArray[beginIndex] || data > srcArray[endIndex] || beginIndex > endIndex) {
            return -1;
        }
        if (data > srcArray[middle]) {
            return binarySearch(srcArray, data, middle, endIndex);
        } else if (data < srcArray[middle]) {
            return binarySearch(srcArray, data, beginIndex, middle);
        } else {
            return middle;
        }
    }


}
