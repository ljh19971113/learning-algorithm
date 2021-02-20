package com.ljh.chapter2.section2.example;

import com.ljh.chapter2.Examle;
import com.ljh.utils.GenerateIntegerArrayFactory;

public class DownToUpMergeSort extends Examle {

    private static DownToUpMergeSort downToUpMergeSort = new DownToUpMergeSort();

    private Comparable[] aux;

    public static void sort(Comparable[] a) {
        downToUpMergeSort.doSort(a);
    }

    @Override
    public void doSort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1;sz < N;sz = sz+sz) {
            for (int lo=0; lo < N-sz; lo += sz+sz) {
                merge(lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1),a);
            }
        }
    }

    private void merge(int start, int mid, int end, Comparable[] a) {
        if (start >= end) {
            return;
        }
        for (int i=start; i<=end; i++) {
            aux[i] = a[i];
        }
        int i = start,j = mid+1;
        for (int k=start;k<=end;k++) {
            if (i > mid) {
                a[k] = aux[j++];
            }else if (j > end) {
                a[k] = aux[i++];
            }else if(less(aux[i],aux[j])) {
                a[k] = aux[i++];
            }else {
                a[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] integers = GenerateIntegerArrayFactory.generateRandomArray(1000);
        sort(integers);
        System.out.println(downToUpMergeSort.isSort(integers));
        downToUpMergeSort.show(integers);
    }
}
