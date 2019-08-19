package com.yimm.heap;

/**
 * Author: sy
 * Create:2019-08-05
 * 12:11
 */
public interface Heap {
    void AdjustDown(int root,int len);

    public void initHeap(int[] array);

    void AdjustUp(int child);

    void pushHeap(int item);

    int popHeap();

    int getHeapTop();

    void HeapSort();

    void show();
}
