package com.ljh.chapter2.section1.example;

import com.ljh.chapter2.Examle;
import com.ljh.utils.GenerateIntegerArrayFactory;
import edu.princeton.cs.algs4.StdOut;

/**
 * 选择排序<br>
 * 第一轮从第一个元素开始，选出最小的元素，并和第一个元素交换位置<br>
 * 第二轮从第二个元素开始，选出最小元素，并与第二个元素交换位置<br>
 * 如此循环往复，直到整个数组为顺序数组为止。<br>
 */
public class Selection extends Examle {

    private static Selection selection = new Selection();

    @Override
    public void doSort(Comparable[] a) {
        for (int i=0; i<a.length; i++) {
            int min = i;
            for (int j=i+1; j<a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, min, i);
        }
    }

    public static void sort(Comparable[] a) {
        selection.doSort(a);
    }

    public static void main(String[] args) {
        Integer[] integers = GenerateIntegerArrayFactory.generateRandomArray(1000);
        selection.sort(integers);
        StdOut.println(selection.isSort(integers));
        selection.show(integers);
    }
}
