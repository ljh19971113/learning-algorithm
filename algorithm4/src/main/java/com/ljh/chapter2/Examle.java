package com.ljh.chapter2;

import edu.princeton.cs.algs4.StdOut;

public abstract class Examle {

    public abstract void sort(Comparable[] a) ;

    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void show(Comparable[] a) {
        for (int i=0; i<a.length; i++) {
            if (i%100 == 0 && i != 0) {
                StdOut.println();
            }
            StdOut.print(a[i] + " ");
        }
    }

    public boolean isSort(Comparable[] a) {
        for (int i=1; i<a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }
}
