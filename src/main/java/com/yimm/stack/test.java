package com.yimm.stack;

/**
 * Author: sy
 * Create:2019-08-10
 * 10:35
 */
public class test {
    public static void main(String[] args) {
        MystackImpl mystack=new MystackImpl(10);
        mystack.push(1);
        mystack.push(29);
        System.out.println(mystack.size());
        System.out.println(mystack.peek());
        mystack.pop();
        System.out.println(mystack.peek());
    }
}
