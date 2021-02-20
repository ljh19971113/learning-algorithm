package com.ljh.chapter2.section2.example;

import com.ljh.chapter2.Examle;
import com.ljh.utils.GenerateIntegerArrayFactory;

public class UpToDownMergeSort extends Examle {

    private static UpToDownMergeSort mergeSort = new UpToDownMergeSort();

    private Comparable[] aux;

    @Override
    public void doSort(Comparable[] a) {
        aux = new Comparable[a.length];
        doSort(a, 0, a.length-1);
    }

    public static void sort(Comparable[] a) {
        mergeSort.doSort(a);
    }

    private void doSort(Comparable[] a, int start, int end) { //[start,end]
        if (start >= end) {
            return;
        }
        int mid = (end - start)/2 + start;
        doSort(a, start, mid);
        doSort(a, mid+1, end);
        merge(a, start, mid, end);
    }

    private void merge(Comparable[] a, int start, int mid, int end) {
        int i = start,j=mid+1;
        for (int k=start; k<=end; k++) {
            aux[k] = a[k];
        }
        for (int k=start; k<=end; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            }else if (j > end) {
                a[k] = aux[i++];
            }else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            }else {
                a[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] integers = GenerateIntegerArrayFactory.generateRandomArray(1000);
        sort(integers);
        System.out.println(mergeSort.isSort(integers));
        mergeSort.show(integers);
    }
}
