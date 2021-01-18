package com.ljh.chapter2.section1.example;

import com.ljh.chapter2.DrawExample;
import com.ljh.utils.GenerateIntegerArrayFactory;

public class DrawSelection extends DrawExample {

    private static DrawSelection drawSelection = new DrawSelection();

    @Override
    public void doSort(Integer[] a) {
        super.doSort(a);
        for (int i=0; i<a.length; i++) {
            int min = i;
            for (int j=i+1; j<a.length; j++) {
                if (less(a, j, min)) {
                    min = j;
                }
            }
            exch(a, min, i);
        }
    }

    public static void sort(Integer[] a) {
        drawSelection.doSort(a);
    }

    public static void main(String[] args) {
        Integer[] integers = GenerateIntegerArrayFactory.generateRandomArray(10);
        sort(integers);
        System.out.println(drawSelection.isSort(integers));
        drawSelection.show(integers);
    }
}
