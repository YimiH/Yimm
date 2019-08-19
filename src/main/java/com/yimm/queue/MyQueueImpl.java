package com.yimm.queue;

/**
 * Author: sy
 * Create:2019-08-10
 * 11:08
 */
public class MyQueueImpl implements IMyQueue {
    class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    private Node front;
    private Node rear;
    private int usedSize;

    public MyQueueImpl(){
        this.front=null;
        this.rear=null;
        this.usedSize=0;
    }

    @Override
    public boolean empty() {
        return this.usedSize==0;
    }

    @Override
    public int peek() {
        return 0;
    }

    @Override
    public int poll() {
        return 0;
    }

    @Override
    public void add(int item) {

    }

    @Override
    public int size() {
        return 0;
    }
}
