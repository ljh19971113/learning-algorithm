package com.ljh.chapter2.section1.example;

import com.ljh.chapter2.DrawExample;
import com.ljh.utils.GenerateIntegerArrayFactory;

public class DrawShell extends DrawExample {

    private static DrawShell drawShell = new DrawShell();

    @Override
    public void doSort(Integer[] a) {
        super.doSort(a);
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i=h; i<N; i++) {
                for (int j=i; j>=h && less(a, j, j-h); j-=h) {
                    exch(a, j, j-h);
                }
            }
            h /= 3;
        }
    }

    public static void sort(Integer[] a) {
        drawShell.doSort(a);
    }

    public static void main(String[] args) {
        Integer[] integers = GenerateIntegerArrayFactory.generateRandomArray(10);
        sort(integers);
        System.out.println(drawShell.isSort(integers));
        drawShell.show(integers);
    }
}
