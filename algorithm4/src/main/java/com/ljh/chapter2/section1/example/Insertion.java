package com.ljh.chapter2.section1.example;

import com.ljh.chapter2.Examle;
import com.ljh.utils.GenerateIntegerArrayFactory;
import edu.princeton.cs.algs4.StdOut;

/**
 * 插入排序<br>
 * 从左至右，遍历数组并将当前指向元素插入到左边已经有序的序列<br>
 * 从第二个元素开始，第一个元素天然有序（只有一个）<br>
 * 将第二个元素插入到前面有序队列的正确位置（第一个元素前后）<br>
 * 然后继续往下遍历，每次都将当前所遍历的元素添加到左边有序序列的正确位置，以保证左侧序列始终有序<br>
 * 遍历完成则排序结束<br>
 */
public class Insertion extends Examle {

    private static Insertion insertion = new Insertion();

    @Override
    public void doSort(Comparable[] a) {
        for (int i=1; i<a.length; i++) {
            for (int j=i; j>0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    public static void sort(Comparable[] a) {
        insertion.doSort(a);
    }

    public static void main(String[] args) {
        Integer[] integers = GenerateIntegerArrayFactory.generateRandomArray(1000);
        insertion.sort(integers);
        StdOut.println(insertion.isSort(integers));
        insertion.show(integers);
    }
}
