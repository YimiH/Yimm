package com.yimm.stack;

/**
 * Author: sy
 * Create:2019-08-10
 * 10:33
 */
public class MystackImpl implements IMyStack {
    //存放数据元素的数组
    private int[] elem;
    //当前可以存放数据元素的下标
    private int top;
    private int usedSize;

    public MystackImpl(int size){
        this.elem=new int[size];
        this.top=0;
        this.usedSize=0;
    }


    public boolean isFull(){
        return this.top==this.elem.length;
    }

    @Override
    public void push(int item) {
        if(isFull()){
            throw new UnsupportedOperationException("栈为满,无法入栈!!!");
        }
        this.elem[this.top++]=item;
        this.usedSize++;
    }


    @Override
    public int pop() {
        if(isEmpty()){
            throw new UnsupportedOperationException("栈为空，无法出栈!!!");
        }
        this.top--;
        this.usedSize--;
        return this.elem[this.top];
    }

    @Override
    public int peek() {
        if(isEmpty()){
            throw new UnsupportedOperationException("栈为空!!!");
        }
        return this.elem[this.top-1];
    }

    @Override
    public boolean isEmpty() {
        return this.usedSize==0;
    }

    @Override
    public int size() {
        return this.usedSize;
    }
}
