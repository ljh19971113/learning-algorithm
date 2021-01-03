package com.ljh.chapter2.section1.example;

import com.ljh.chapter2.Examle;
import com.ljh.utils.GenerateIntegerArrayFactory;
import edu.princeton.cs.algs4.StdOut;

/**
 * 希尔排序<br>
 * 插入排序的增强版？<br>
 * 通过将数组在一次次遍历中使用大到小的权值划分为一个个子数组，先对子数组进行插入排序<br>
 * 然后在权值变化的过程中，数组自然而然的部分有序<br>
 * 当权值最终为1时，数组完全有序<br>
 */
public class Shell extends Examle {

    public static Shell shell = new Shell();

    @Override
    public void doSort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = h * 3 +1;
        }
        while (h >= 1) {
            for (int i=h; i<N; i++) {
                for (int j=i; j>=h && less(a[j], a[j-h]); j-=h) {
                    exch(a, j, j-h);
                }
            }
            h /= 3;
        }
    }

    public static void sort(Comparable[] a) {
        shell.doSort(a);
    }

    public static void main(String[] args) {
        Integer[] integers = GenerateIntegerArrayFactory.generateRandomArray(1000);
        sort(integers);
        StdOut.println(shell.isSort(integers));
        shell.show(integers);
    }
}
