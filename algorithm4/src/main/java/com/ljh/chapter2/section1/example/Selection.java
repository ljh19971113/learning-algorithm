package com.ljh.chapter2.section1.example;

import com.ljh.chapter2.Examle;
import com.ljh.utils.GenerateIntegerArrayFactory;
import edu.princeton.cs.algs4.StdOut;

/**
 * 选择排序<br>
 * 第一轮从第一个元素开始，选出最小的元素，并和第一个元素交换位置<br>
 * 第二轮从第二个元素开始，选出最小元素，并与第二个元素交换位置<br>
 * 如此循环往复，直到整个数组为顺序数组位置。<br>
 */
public class Selection extends Examle {

    @Override
    public void sort(Comparable[] a) {
        for (int i=0; i<a.length; i++) {
            int min = i;
            for (int j=i+1; j<a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            if (min != i) {
                exch(a, min, i);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] integers = GenerateIntegerArrayFactory.generateRandomArray(1000);
        Selection selection = new Selection();
        selection.sort(integers);
        StdOut.println(selection.isSort(integers));
        selection.show(integers);
    }
}
