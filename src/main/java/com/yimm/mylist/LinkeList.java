package com.yimm.mylist;

/**
 * Author: sy
 * Create:2019-07-24
 * 09:38
 */

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class LinkeList {
    public Node first;
    public Node last;

    /*链表判空*/
    public boolean isEmpty(){
        return first==null;
    }

    /*打印链表*/
    public void print(){
        Node cur=first;
        while(cur!=null){
            System.out.println(cur.data+"->");
            cur=cur.next;
        }
        System.out.println();
    }

    /*插入*/
    public void insert(Node ptr){
        Node tmp;
        Node newNode;
        /*原链表为空*/
        if(this.isEmpty()) {
            first = ptr;
            last=ptr;
        }else{

        }


    }

    /*串联两个链表*/
    public LinkeList concatenate(LinkeList head1,LinkeList head2){
        LinkeList ptr;
        ptr=head1;
        while(ptr.last.next!=null) {
            ptr.last = ptr.last.next;
        }
        ptr.last.next=head2.first;
        return head1;
    }


    public static void main(String[] args) {

    }
}
