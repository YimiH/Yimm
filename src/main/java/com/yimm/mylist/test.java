package com.yimm.mylist;

/**
 * Author: sy
 * Create:2019-07-24
 * 10:29
 */
public class test {



    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //此处应考虑一条链表为空
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode cur1=l1;
        ListNode cur2=l2;
        ListNode result=null;
        ListNode last=null;
        while(cur1!=null&&cur2!=null){
            if(cur1.val<=cur2.val){
                ListNode next=cur1.next;
                //将cur1尾插
                if(result==null){
                    result=cur1;
                }else{
                    last.next=cur1;
                }
                last=cur1;
                cur1=next;
            }else{
                //将cur2尾插
                ListNode next=cur2.next;
                if(result==null){
                    result=cur2;
                }else{
                    last.next=cur2;
                }
                last=cur2;
                cur2=next;
            }
        }
        //若遍历结束有一条链表仍不为空直接将其连接到结果链表之后
        if(cur1!=null){
            last.next=cur1;
        }else if(cur2!=null){
            last.next=cur2;
        }
        return result;
    }


    public static ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null)
            return null;
        ListNode prev=new ListNode(0);
        ListNode cur=pHead;
        ListNode next=cur.next;
        prev.next=pHead;
        while(next!=null){
            if(cur.val==next.val){
                cur=prev;
                next=next.next;
                cur.next=next;
            }else{
                prev=cur;
                cur=next;
                next=next.next;
            }
        }
        return pHead;
    }


    public static ListNode FindKthToTail(ListNode head,int k) {
        if(head==null ||k<=0)
            return head;
        ListNode slow=head;
        ListNode fast=head;
        while(k>0 && fast!=null){
            fast=fast.next;
            k--;
        }
        if(k>0){
            return null;
        }else{
            while(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        /*List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(4);

        System.out.println(list.size());
        System.out.println(list.get(2));
        int[] array=new int[]{};
        System.out.println(array.length);*/


        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);

        ListNode d=new ListNode(4);
        ListNode e=new ListNode(5);
        ListNode f=new ListNode(1);
        ListNode g=new ListNode(2);


        a.next=b;
        b.next=c;
        c.next=d;

        d.next=e;
        e.next=null;

       /* f.next=g;
        g.next=null;*/

        ListNode res=FindKthToTail(a,3);
        while(res!=null){
            System.out.print(res.val);
            res=res.next;
        }


    }
}
