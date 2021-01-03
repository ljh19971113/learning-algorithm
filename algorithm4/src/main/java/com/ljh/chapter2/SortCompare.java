package com.ljh.chapter2;

import com.ljh.chapter2.section1.example.Insertion;
import com.ljh.chapter2.section1.example.Selection;
import com.ljh.chapter2.section1.example.Shell;
import com.ljh.utils.GenerateIntegerArrayFactory;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {

    public static final String INSERTION = "Insertion";
    public static final String SELECTION = "Selection";
    public static final String SHELL = "Shell";
    public static final String MERGE = "Merge";
    public static final String QUICK = "Quick";
    public static final String HEAP = "Heap";

    public static double time(String arg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        switch (arg) {
            case INSERTION:
                Insertion.sort(a);
                break;
            case SELECTION:
                Selection.sort(a);
                break;
            case SHELL:
                Shell.sort(a);
                break;
            case MERGE:
            case QUICK:
            case HEAP:
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String arg, int N, int T) {
        double total = 0.0;
        Integer[] a = new Integer[N];
        for (int i=0; i<T; i++) {
            a = GenerateIntegerArrayFactory.generateRandomArray(N);
            total += time(arg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        int N = 10000;
        int T = 100;
        double t1 = timeRandomInput(INSERTION, N, T);
        double t2 = timeRandomInput(SELECTION, N, T);
        double t3 = timeRandomInput(SHELL, N, T);
        StdOut.printf("测试样例大小为:%d,测试次数为:%d\n", N, T);
        StdOut.printf("%s测试时间为:%.1f\n",INSERTION,t1);
        StdOut.printf("%s测试时间为:%.1f\n",SELECTION,t2);
        StdOut.printf("%s测试时间为:%.1f\n",SHELL,t3);
    }
}
