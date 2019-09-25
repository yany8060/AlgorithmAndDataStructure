package com.yany.algorithms.recursive;

/**
 * 斐波那契数列(递归实现)
 *
 * @author yanyong on 2019/2/20
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(calculate(11));
    }

    public static int calculate(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int r = calculate(n - 1) + calculate(n - 2);
        System.out.println("r(" + r + ")= " + calculate(n - 1) + " + " + calculate(n - 2));
        return r;
    }

}
