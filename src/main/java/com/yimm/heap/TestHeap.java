package com.yimm.heap;

import java.util.Arrays;

/**
 * Author: sy
 * Create:2019-08-06
 * 16:14
 */
public class TestHeap implements Heap {
    /*此处堆的实现结构为数组*/
    private int[] elem;
    //当前使用空间大小
    private int usedSize;
    private static final int  DEFAULT_SIZE=10;

    public TestHeap(){
        this.elem=new int[DEFAULT_SIZE];
        this.usedSize=0;
    }

    //向下调整
    /**
     * @name: AdjustDown
     * @description: 向下调整
     * @param root
     * @param len  调整的范围（当前数组的已用大小）
     * @return: void
     *
     *
    */
    public void AdjustDown(int root, int len) {
        int parent=root;
        /*用来指向左右孩子中的最大值进行调整*/
        int child=2*parent+1;

        while(child<len){
            //判断是否存在右孩子
            if(child+1<len){
                if(this.elem[child]<this.elem[child+1])
                    child=child+1;
            }
            //child的存放的是左右孩子的最大值
            if(this.elem[parent]<this.elem[child]){
                //交换
                int tmp=this.elem[parent];
                this.elem[parent]=this.elem[child];
                this.elem[child]=tmp;
                //调整一个可能会影响下面的节点
                parent=child;
                child=2*parent+1;
            }else{
                break;
            }
        }
    }

    //创建一个(大根)堆
    /*
    * 子推父：n-->（n-1）/2
    * 父推子：n -->2n+1(左孩子) 2n+2（右孩子）
    *
    * 此处需要从子节点进行向上调整
    * */
    public void initHeap(int[] array) {
        for(int i=0;i<array.length;i++){
            this.elem[i]=array[i];
            this.usedSize++;
        }
        //从最后一个节点开始
        for(int i=(array.length-1)/2;i>=0;i--){
            AdjustDown(i,this.usedSize);
        }

    }

    public void AdjustUp(int child) {
        int parent=(child-1)/2;
        while(child>0){
            if(this.elem[parent]<this.elem[child]){
                int tmp=this.elem[parent];
                this.elem[parent]=this.elem[child];
                this.elem[child]=tmp;

                child=parent;
                parent=(child-1)/2;
            }else {
                break;
            }
        }
    }


    /**
     * @name: isFull
     * @description:  判断是否已满，因为此时采用数组，所以在插入之前需要判断是否已满，避免数组下标越界
     * @return: boolean
     *
    */
    public boolean isFull(){
        return this.usedSize==this.elem.length;
    }


    /**
     * @name: pushHeap
     * @description: 采用向上调整，插入应在最后一个位置插入,前提是堆已经为大根堆
     * @param item
     * @return: void
     *
    */
    public void pushHeap(int item) {
        //插入前先判满
        if(isFull()){
            this.elem= Arrays.copyOf(this.elem,2*this.elem.length);
        }
        //先放再调整
        this.elem[this.usedSize]=item;
        this.usedSize++;
        AdjustUp(this.usedSize-1);

    }

    public boolean isEmpty(){
        return this.usedSize==0;
    }


    /**
     * @name: popHeap
     * @description: 删除元素
     * @return: int
     *
    */
    public int popHeap() {
        if(isEmpty())
            throw new UnsupportedOperationException("堆为空");

        int oldData=this.elem[0];
        //进行向下调整
        int tmp=this.elem[0];
        this.elem[0]=this.elem[this.usedSize-1];
        this.elem[this.usedSize-1]=tmp;

        this.usedSize--;
        AdjustDown(0,this.usedSize);
        return oldData;

    }

    /**
     * @name: getHeapTop
     * @description: 获取堆顶元素
     * @return: int
     *
    */
    public int getHeapTop() {
        if(isEmpty()){
            throw new UnsupportedOperationException("堆为空");
        }

        return elem[0];
    }


    /**
     * @name: HeapSort
     * @description: 堆排序(先将堆调整为大根堆)
     * 时间复杂度：O（nlogn）
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @return: void
     *
    */
    public void HeapSort() {
        //前提条件是当前堆已经为大根堆
        int end=this.usedSize-1;

        while(end>0){
            int tmp=this.elem[0];
            this.elem[0]=this.elem[end];
            this.elem[end]=tmp;

            AdjustDown(0,end);
            end--;
        }

    }

    public void show() {
        for(int i=0;i<this.usedSize;i++){
            System.out.print(this.elem[i]+" ");
        }
    }
}
