package com.ljh.chapter2.section2.example;

import com.ljh.chapter2.DrawExample;
import com.ljh.utils.GenerateIntegerArrayFactory;

import java.util.Arrays;

public class DrawMergeSort extends DrawExample {
    
    private static DrawMergeSort drawMergeSort = new DrawMergeSort();
    
    private Integer[] aux;
    
    @Override
    public void doSort(Integer[] a) {
        super.doSort(a);
        aux = new Integer[a.length];
        Arrays.fill(aux, 0);
        doSort(a, 0, a.length-1);
    }
    
    public static void sort(Integer[] a) {
        drawMergeSort.doSort(a);
    }
    
    private void doSort(Integer[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start)/2;
        doSort(a, start, mid);
        doSort(a, mid+1, end);
        merge(a, start, mid, end);
    }

    private void merge(Integer[] a, int start, int mid, int end) {
        int i = start,j = mid+1;
        for (int k = start; k <= end; k++) {
            aux[k] = a[k];
        }
        for (int k=start; k<=end; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            }else if (j > end) {
                a[k] = aux[i++];
            }else if (less(aux, i, j)) {
                a[k] = aux[i++];
            }else {
                a[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] integers = GenerateIntegerArrayFactory.generateRandomArray(10);
        sort(integers);
        System.out.println(drawMergeSort.isSort(integers));
        drawMergeSort.show(integers);
    }

}
