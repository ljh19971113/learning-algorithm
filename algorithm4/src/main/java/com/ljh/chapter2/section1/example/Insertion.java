package com.ljh.chapter2.section1.example;

import com.ljh.chapter2.Examle;
import com.ljh.utils.GenerateIntegerArrayFactory;
import edu.princeton.cs.algs4.StdOut;

/**
 * 插入排序<br>
 * 从左至右，遍历数组并将当前指向元素插入到左边已经排序好的序列<br>
 */
public class Insertion extends Examle {

    @Override
    public void sort(Comparable[] a) {
        for (int i=1; i<a.length; i++) {
            for (int j=i; j>0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] integers = GenerateIntegerArrayFactory.generateRandomArray(1000);
        Insertion insertion = new Insertion();
        insertion.sort(integers);
        StdOut.println(insertion.isSort(integers));
        insertion.show(integers);
    }
}
