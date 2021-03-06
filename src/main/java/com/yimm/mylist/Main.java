package com.yimm.mylist;

/**
 * 项目名称：Structure
 *
 * @Author: Yimm
 * @Date：2019-08-17 09:23
 * @Description：TODO
 */

import java.util.Scanner;

public class Main {
    static class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int k = scanner.nextInt();
        String[] strings = string.split(" ");
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        for(String str : strings) {
            ListNode node = new ListNode(Integer.valueOf(str));
            tail.next = node;
            tail = tail.next;
        }
        head = head.next;
        ListNode newHead = solution1(head, k);
        while(newHead != null) {
            if(newHead.next == null) System.out.println(Integer.valueOf(newHead.val));
            else System.out.print(Integer.valueOf(newHead.val) + " ");
            newHead = newHead.next;
        }
    }
    public static ListNode solution1(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(true) {
            head = solution2(head, k);
            if(head == null) break;

        }
        return dummy.next;
    }
    public static ListNode solution2(ListNode head, int k) {
        ListNode nk = head;
        for(int i = 0; i < k; i++) {
            if(nk == null) return null;
            nk = nk.next;
        }
        if(nk == null) return null;
        ListNode nkPlus = nk.next;
        ListNode n1 = head.next;
        ListNode pre = null;
        ListNode cur = n1;
        while(cur != nkPlus) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        head.next = nk;
        n1.next = nkPlus;
        return n1;
    }
}