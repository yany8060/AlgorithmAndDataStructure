package com.yany.datastructures.array;

/**
 * @author yanyong on 2019/11/7
 */
public class Array {
    private int data[];
    /**
     * 数组长度
     */
    private int n;
    private int count;

    public Array(int capacity) {
        data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    public int find(int index) {
        if (index >= count || index < 0) {
            return -1;
        }
        return data[index];
    }

    public boolean insert(int index, int value) {
        if (index > count || index < 0 || count == n) {
            return false;
        }

        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        count++;
        return true;
    }

    public boolean delete(int index) {
        if (index > count || index < 0) {
            return false;
        }

        for (int i = index; i < count - 1; i++) {
            data[i] = data[i + 1];
        }
        count--;
        return true;
    }

}
