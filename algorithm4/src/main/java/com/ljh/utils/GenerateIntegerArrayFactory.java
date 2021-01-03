package com.ljh.utils;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 用来生成各类Integer数组
 */
public class GenerateIntegerArrayFactory {

    /**
     * 返回大小为N的乱序数组，数值范围在[min,max]
     * @param N 返回数组大小
     * @param min 数组中最小值
     * @param max 数组中最大值
     * @return 大小为N的乱序数组，数值范围在[min,max]
     */
    public static Integer[] generateRandomArray(int N, int min, int max) {
        Integer[] res = new Integer[N];
        for (int i=0; i<N; i++) {
            res[i] = StdRandom.uniform(min, max+1);
        }
        return res;
    }

    /**
     * 返回大小为N的乱序数组，数值范围在[0,N]
     * @param N 返回数组大小
     * @return 大小为N的乱序数组，数值范围在[0,N]
     */
    public static Integer[] generateRandomArray(int N) {
        Integer[] res = new Integer[N];
        for (int i=0; i<N; i++) {
            res[i] = StdRandom.uniform(1,N+1);
        }
        return res;
    }

    /**
     * 返回一个大小为N的顺序数组，数值范围为[1,N]
     * @param N 返回数组大小
     * @return 大小为N的顺序数组，数值范围为[1,N]
     */
    public static Integer[] generateOrderArray(int N) {
        Integer[] res = new Integer[N];
        for (int i=0; i<N; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
