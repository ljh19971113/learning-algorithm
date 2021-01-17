package com.ljh.chapter2.section1.example;

import com.ljh.chapter2.DrawExample;
import com.ljh.utils.GenerateIntegerArrayFactory;
import edu.princeton.cs.algs4.StdOut;

public class DrawInsertion extends DrawExample {

    @Override
    public void doSort(Integer[] a) {
        super.doSort(a);
        for (int i=1; i<a.length; i++) {
            for (int j=i; j>0 && less(a , j, j-1); j--) {
                exch(a, j, j-1);
            }
        }
    }

    private static DrawInsertion drawInsertion = new DrawInsertion();

    public static void sort(Integer[] a) {
        drawInsertion.doSort(a);
    }

    public static void main(String[] args) {
        Integer[] integers = GenerateIntegerArrayFactory.generateRandomArray(10);
        drawInsertion.sort(integers);
        StdOut.println(drawInsertion.isSort(integers));
        drawInsertion.show(integers);
    }
}
