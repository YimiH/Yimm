package com.yimm.mylist;

/**
 * Author: sy
 * Create:2019-08-04
 * 13:22
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        this.val=x;
    }


    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return null;
        ListNode prev=new ListNode(-1);
        ListNode cur=new ListNode(-1);
        prev.next=head;
        ListNode header=prev;
        cur=head;
        while(cur!=null){
            if(cur.val!=val){
                prev=cur;
                cur=cur.next;
            }else{
                prev.next=cur.next;
                cur=prev.next;
            }
        }
        return header.next;
    }


    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null || k<=0 )
            return null;
        ListNode fast=head;
        ListNode slow=head;

        while(k-->0){
            if(fast.next!=null){
                fast=fast.next;
            }else{
                return null;
            }
        }

        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }


    public static void print(ListNode head){
        if(head==null){
            return;
        }
        ListNode cur=new ListNode(-1);
        cur=head;
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }


    /*public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;

        ListNode n1=l1;
        ListNode n2=l2;
        ListNode res=null;
        ListNode pos=res;
        while(n1!=null && n2!=null){
            if(n1.val<=n2.val){
                if(res==null){
                    res=n1;
                    pos=res;
                }else{
                    res.next=n1;
                    res=res.next;
                }
                n1=n1.next;
            }
            else{
                if(res==null){
                    res=n2;
                    pos=res;
                }else{
                    res.next=n2;
                    res=res.next;
                }
                n2=n2.next;
            }
        }

        if(n1!=null)
            res.next=n1;
        else if(n2!=null)
            res.next=n2;

        return pos;
    }
*/

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode last = null;
        ListNode merList = new ListNode(-1);
        while (l1 != null && l2 != null) {
            //l1链表的节点数值大于l2，将l1的节点尾插到merList链表上
            if (l1.val < l2.val) {
                if (last == null) {
                    last = l1;
                    merList.next = last;
                } else
                    last.next = l1;
                l1 = l1.next;
            }
            //l2链表的节点数值大于l1，将l2的节点尾插到merList链表上
            if (l2.val < l1.val) {
                if (last == null) {
                    last = l2;
                    merList.next = last;
                } else
                    last.next = l2;
                l2 = l2.next;
            }
        }
        //l1的仍有剩余节点，将其连接到merList上
        if (l1 != null)
            last.next = l1;
        //l2的仍有剩余节点，将其连接到merList上
        if (l2 != null)
            last.next = l2;

        return merList.next;
    }


    public static void main(String[] args) {
        ListNode head1=new ListNode(1);
        ListNode a=new ListNode(2);
        ListNode b=new ListNode(4);

        ListNode head2=new ListNode(1);
        ListNode d=new ListNode(3);
        ListNode e=new ListNode(4);

        head1.next=a;
        a.next=b;
        b.next=null;

        head2.next=d;
        d.next=e;
        e.next=null;
        //head.removeElements(head,1);
        ListNode res=head1.mergeTwoLists(head1,head2);

        //ListNode res1=head1.FindKthToTail(head1,1);
        print(res);



    }
}
