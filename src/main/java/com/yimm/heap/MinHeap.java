package com.yimm.heap;

/**
 * Author: sy
 * Create:2019-07-18
 * 07:18
 */
public class MinHeap {
    //堆的存储结构--数组
    private int[] data;


    //传入一个数组并构建一个堆
    public MinHeap(int[] data){
        this.data=data;
        /*此处无须传值，构建时直接用本类的数组属性即可*/
        buildHeap();
    }

    /*将数组转化为最小堆*/
    private void buildHeap() {
        // 完全二叉树只有数组下标小于或等于 (data.length) / 2 - 1 的元素有孩子结点，遍历这些结点。
        for (int i = (data.length) / 2 - 1; i >= 0; i--)
        {
            // 对有孩子结点的元素heapify
            heapify(i);
        }

    }

    private void heapify(int i) {
        //获取左右子节点的下标
        int le=left(i);
        int ri=right(i);

        //将当前值最小的元素下标存储在一个临时变量内
        int smallest=i;

        //存在左节点,且左节点的值小于根节点的值
        if (le < data.length && data[le] < data[i])
            smallest = le;

        //存在右节点，且右节点的值小于以上比较的smallest下标处的值
        if(ri<data.length && data[ri] <data[smallest])
            smallest=ri;

        //左右节点的值都大于根节点则无需操作，直接返回
        if(i==smallest)
            return;
        //交换根节点和左右节点中最小的节点（smallest）的值，替换该值
        swap(i,smallest);

        //由于替换后会影响左右子树，对其进行向下调整
        heapify(smallest);
    }


    private int right(int i) {
        return (i+1)<<1;
    }

    private int left(int i) {
        return ((i+1)<<1)-1;
    }


    private void swap(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }


    // 获取对中的最小的元素，根元素
    public int getRoot()
    {
        return data[0];
    }

    // 替换根元素，并重新heapify
    public void setRoot(int root)
    {
        data[0] = root;
        heapify(0);
    }


}
