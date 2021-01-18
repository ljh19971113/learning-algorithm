package com.ljh.chapter2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

public abstract class DrawExample {

    private static Integer MAX_VALUE = 0;
    private static Integer MIN_VALUE = 0;

    static {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        StdDraw.setCanvasSize(screen.width,screen.height);
        StdDraw.setPenColor(StdDraw.GRAY);
    }

    public  void doSort(Integer[] a) {
        MAX_VALUE = getMax(a);
        MIN_VALUE = getMin(a);
        double padding = Math.abs(MAX_VALUE - MIN_VALUE) * 0.01;
        StdDraw.setXscale(-0.01,1.01);
        StdDraw.setYscale(MIN_VALUE - padding, MAX_VALUE + padding);
    }

    public boolean less(Integer[] a, int i, int j) {
        draw(a, i, j, OpStatus.COMPARE);
        return a[i].compareTo(a[j]) < 0;
    }

    public void exch(Integer[] a, int i, int j) {
        Integer temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        draw(a, i, j, OpStatus.SWAP);
    }

    public void show(Integer[] a) {
        for (int i=0; i<a.length; i++) {
            if (i%100 == 0 && i != 0) {
                StdOut.println();
            }
            StdOut.print(a[i] + " ");
        }
    }

    public boolean isSort(Integer[] a) {
        for (int i=1; i<a.length; i++) {
            if (less(a, i, i-1)) {
                return false;
            }
        }
        return true;
    }

    private void draw(Integer[] a, int i, int j , OpStatus opStatus) {
        StdDraw.clear();
        int N = a.length;
        for (int k=0; k<N; k++) {
            Double x = 1.0 * k/N;
            Double y = a[k] / 2.0;
            Double rw = 0.4/N;
            Double rh = y;
            if (k == i || k == j) {
                switch (opStatus) {
                    case COMPARE:
                        StdDraw.setPenColor(StdDraw.BLACK);
                        break;
                    case SWAP:
                        StdDraw.setPenColor(StdDraw.RED);
                        break;
                }
            } else {
                StdDraw.setPenColor(StdDraw.GRAY);
            }
            StdDraw.filledRectangle(x,y,rw,rh);
        }
        StdDraw.show();
        StdDraw.pause(500);
    }

    private Integer getMax(Integer[] a) {
        int max = a[0];
        for (int i : a) {
            max = i > max ? i : max;
        }
        return max;
    }

    private Integer getMin(Integer[] a) {
        int min = 0;
        for (int i : a) {
            min = i < min ? i : min;
        }
        return min;
    }

    enum OpStatus {
        COMPARE,
        SWAP
    }

    public static void main(String[] args) {
        DrawExample example = new DrawExample() {
            @Override
            public void doSort(Integer[] a) {
                super.doSort(a);
            }
        };
        Integer[] a = {11,13,38,99,23,232,99};
        example.draw(a,1,2 , OpStatus.COMPARE);
    }
}
