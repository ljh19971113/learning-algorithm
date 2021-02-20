package com.ljh.chapter2.section4;

import com.ljh.chapter2.Examle;
import com.ljh.utils.GenerateIntegerArrayFactory;

public class HeapSort extends Examle {

    private static HeapSort heapSort = new HeapSort();

    public static void sort(Comparable[] a) {
        heapSort.doSort(a);
    }

    @Override
    public void doSort(Comparable[] a) {
        int N = a.length-1;
        for (int k = N/2; k>=1; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exch(a,1,N--);
            sink(a,1,N);
        }
    }

    private void sink(Comparable[] a, int k, int n) {
        if (n > a.length) {
            return;
        }
        while (k*2 <= n) {
            int j = k*2;
            if (j < n && less(a[j],a[j+1])) j++;
            if (less(a[j],a[k])) break;
            exch(a,j,k);
            k = j;
        }
    }

    @Override
    public boolean isSort(Comparable[] a) {
        for (int i=2; i<a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] integers = GenerateIntegerArrayFactory.generateRandomArray(1000);
        sort(integers);
        System.out.println(heapSort.isSort(integers));
        heapSort.show(integers);
    }

}
