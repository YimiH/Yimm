package com.yimm.heap;

/**
 * Author: sy
 * Create:2019-08-06
 * 16:49
 */
public class TestDemo {
    public static void main(String[] args) {
        TestHeap testHeap=new TestHeap();
        int[] array=new int[]{1,2,3,4,5,6,7,8,9,10};
        testHeap.initHeap(array);
        testHeap.show();
        System.out.println("\n==========================");

        testHeap.pushHeap(11);
        testHeap.show();
        System.out.println("\n==========================");

        testHeap.popHeap();
        testHeap.show();

        System.out.println("\n==========================");
        testHeap.HeapSort();
        testHeap.show();
    }
}
