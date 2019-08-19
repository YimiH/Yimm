package com.yimm.sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: sy
 * Create:2019-08-09
 * 16:56
 */
public class testSortTest {
    private int[] array=new int[]{5,3,2,6,1,4};

    @Test
    public void shellSort() {
    }

    @Test
    public void insertSort() {
        testSort.insertSort(array);
        for (int i:array) {
            System.out.print(i);
        }
    }

    @Test
    public void selectSort() {
    }

    @Test
    public void insertSort2() {
    }

    @Test
    public void quickSort1() {
    }

    @Test
    public void quickSort2() {
    }

    @Test
    public void mergeSort() {
    }
}