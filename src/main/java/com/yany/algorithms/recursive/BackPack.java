package com.yany.algorithms.recursive;


import com.alibaba.fastjson.JSON;

/**
 * 背包问题
 * 背包问题具体例子：假设现有容量10kg的背包，另外有3个物品，分别为a1，a2，a3。
 * 物品a1重量为3kg，价值为4；物品a2重量为4kg，价值为5；物品a3重量为5kg，价值为6。
 * 将哪些物品放入背包可使得背包中的总价值最大？
 *
 * @author yanyong on 2019/2/26
 */
public class BackPack {

    public static void main(String[] args) {
        int w[] = {0, 2, 3, 4, 5, 9};
        int v[] = {0, 3, 4, 5, 8, 10};
        int weight = 20;


//        System.out.println(backPack_Solution_Recursive(w, v, weight, 0, 0));
//        System.out.println(backPack_Solution(w, v, weight, 0));
        System.out.println(total_backPack_Solution(w, v, weight, 0));

    }

    /**
     * 0,1 背包问题 递归解法
     *
     * @param w
     * @param v
     * @param weight
     * @param value
     * @param
     * @return
     */
    public static int backPack_Solution_Recursive(int w[], int v[], int weight, int value, int i) {
        if (i >= w.length) {
            // 递归到末尾
            return value;
        }
        if (weight < w[i]) {
            return value;
        }

        int value1 = backPack_Solution_Recursive(w, v, weight - w[i], value + v[i], i + 1);
        int value2 = backPack_Solution_Recursive(w, v, weight, value, i + 1);
        value = Math.max(value1, value2);

        return value;
    }

    public static int backPack_Solution(int w[], int v[], int weight, int value) {
        int[][] values = new int[6][weight + 1];
        for (int i = 0; i <= 5; i++) {
            values[i][0] = 0;
        }
        for (int j = 0; j <= weight; j++) {
            values[0][j] = 0;
        }

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= weight; j++) {
                if (j < w[i]) {
                    values[i][j] = values[i - 1][j];

                } else {
                    if ((values[i - 1][j - w[i]] + v[i]) > values[i - 1][j]) {
                        values[i][j] = values[i - 1][j - w[i]] + v[i];
                    } else {
                        values[i][j] = values[i - 1][j];
                    }
                }
            }
        }
        return values[5][weight];
    }

    public static int total_backPack_Solution(int w[], int v[], int weight, int value) {
        int[][] values = new int[6][weight + 1];
        for (int i = 0; i <= 5; i++) {
            values[i][0] = 0;
        }
        for (int j = 0; j <= weight; j++) {
            values[0][j] = 0;
        }

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= weight; j++) {
                for (int k = 0; k * w[i] < j; k++) {
                    int v1 = values[i - 1][j - k * w[i]] + k * v[i];
                    int v2 = values[i - 1][j];
                    if (v1 > v2) {
                        values[i][j] = v1;
                    } else {
                        values[i][j] = v2;
                    }
                }
            }
        }

        System.out.println(JSON.toJSONString(values));
        return values[5][weight];
    }


}
