package com.ljh.chapter2.section3;

import com.ljh.chapter2.Examle;
import com.ljh.utils.GenerateIntegerArrayFactory;
import edu.princeton.cs.algs4.StdRandom;

public class Quick extends Examle {

    private static Quick quick = new Quick();

    public static void sort(Comparable[] a) {
        quick.doSort(a);
    }

    @Override
    public void doSort(Comparable[] a) {
        StdRandom.shuffle(a);
        doSort(a,0,a.length-1);
    }

    private void doSort(Comparable[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int partition = partition(a,start,end);
        doSort(a,start,partition-1);
        doSort(a,partition+1,end);
    }

    private int partition(Comparable[] a, int start, int end) {
        int i = start,j = end+1; //一虚一实，保证最后相遇时i,j所指数据小于等于partition
        Comparable partition = a[start];
        while (true) {
            while (less(a[++i],partition)) {
                if (i==end) {
                    break;
                }
            }
            while (less(partition,a[--j])) {
                if (j==start) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a,i,j);
        }
        exch(a,start,j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] integers = GenerateIntegerArrayFactory.generateRandomArray(1000);
        sort(integers);
        System.out.println(quick.isSort(integers));
        quick.show(integers);
    }
}
