package com.yimm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author: sy
 * Create:2019-08-06
 * 17:58
 */
public class TestBinaryTree {

    //二叉树节点类
    class TreeNode{
        char value;
        TreeNode left;
        TreeNode right;

        public TreeNode(char value){
            //引用类型不需要初始化
            this.value=value;
        }
    }

    /**
     * @name: createTestTree
     * @description: 通过字符串创建二叉树
     * @param s
     * @return: com.yimm.tree.TestBinaryTree.TreeNode
     *
    */

    //为了使得每次传入的字符串不同（在向后移动）
    public int i=0;
    public TreeNode createTestTree(String s){
         TreeNode root=null;

         if(s.charAt(i)!='#'){
             root=new TreeNode(s.charAt(i));
             i++;
             root.left= createTestTree(s);
             root.right=createTestTree(s);
         }else{
             i++;
         }

         return root;

    }


   /**
    * @name: binaryTreePrevOrder
    * @description: 前序遍历
    * @param root
    * @return: void
    *
   */
   public void binaryTreePrevOrder(TreeNode root){
        //递归终止条件
        if(root==null)
            return;

        System.out.print(root.value+" ");
        binaryTreePrevOrder(root.left);
        binaryTreePrevOrder(root.right);

    }

    /**
     * @name: binaryTreePrevOrderNonR
     * @description: 二叉树前序遍历非递归
     * @param root
     * @return: void
     *
    */
    void binaryTreePrevOrderNonR(TreeNode root){
       if(root==null)
           return;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode cur=root;
        TreeNode top=root;

        //此时的cur已经走top.right需要重新判断，而加的!stack.empty()是为了在cur为null时重新获取栈顶元素
        while(cur!=null||!stack.empty()){
            //先遍历根的左子树
            while(cur!=null){
                stack.push(cur);
                System.out.print(cur.value+" ");
                cur=cur.left;
            }
            top=stack.pop();
            cur=top.right;

        }

    }

    /**
     * @name: binaryTreeInOrder
     * @description: 中序遍历
     * @param root
     * @return: void
     *
     */
    public void binaryTreeInOrder(TreeNode root){
        //递归终止条件
        if(root==null)
            return;

        binaryTreeInOrder(root.left);
        System.out.print(root.value+" ");
        binaryTreeInOrder(root.right);
    }

    /**
     * @name: binaryTreeInorderNonR
     * @description: 中序遍历非递归
     * @param root
     * @return: void
     *
    */
    void binaryTreeInorderNonR(TreeNode root){
       Stack<TreeNode> stack=new Stack<TreeNode>();
       TreeNode cur=root;
       TreeNode top=null;

       while(cur!=null || !stack.empty()) {

           while (cur != null) {
               stack.push(cur);
               cur=cur.left;
           }
           top = stack.pop();
           System.out.print(top.value+" ");
           cur = top.right;
       }
    }




    /**
     * @name: binaryTreePostOrder
     * @description: 后序遍历
     * @param root
     * @return: void
     *
     */
    public void binaryTreePostOrder(TreeNode root){
        //递归终止条件
        if(root==null)
            return;

        binaryTreePostOrder(root.left);
        binaryTreePostOrder(root.right);
        System.out.print(root.value+" ");
    }


    /**
     * @name: binaryTreePostOrderNonR
     * @description: 后序遍历非递归
     * @param root
     * @return: void
     *
    */
    void binaryTreePostOrderNonR(TreeNode root){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode cur=root;
        TreeNode prev=null;

        while(cur!=null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            //此时根节点不能出栈
            cur=stack.peek();
            //cur.right==prev说明右子树已经被打印过,prev记录的是是否已经被打印过
            if(cur.right==null||cur.right==prev) {
                stack.pop();
                System.out.print(cur.value+" ");
                //右子树不为空，则应将右子树入栈
                prev=cur;
                //防止cur重复入栈
                cur=null;
            } else{
                cur=cur.right;
            }

        }

    }


    /**
     * @name: binaryTreeLevelOrder
     * @description: 层序遍历 运用队列(先进先出思想)
     * @param root
     * @return: void
     *
    */
    void binaryTreeLevelOrder(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root!=null){
            /*
            * LinkedList的add和offer方法的区别
            * offer里面调用了add方法
            * */
            queue.add(root);

        }

        while(!queue.isEmpty()){
            /*
            * 1.拿到队头元素
            * 2.将队头元素左右子树（不为空时）入队
            */
            TreeNode cur=queue.poll();
            System.out.print(cur.value+" ");

            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }

        }
    }




    /**
     * @name: getSize
     * @description: 求树中所有节点的个数，思路类似于后序遍历
     * @param root
     * @return: int
     *
    */
    public int getSize(TreeNode root){
        if(root==null)
            return 0;

        //如果root不为空，其整棵树的节点数为其：左子树+右子树+1
        int left=getSize(root.left);
        int right=getSize(root.right);

        return left+right+1;
    }

    /**
     * @name: getLeafSize
     * @description: 求叶子节点个数，相当于后序遍历
     * @param root
     * @return: int
    */
    public int getLeafSize(TreeNode root){
        //递归终止条件
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;

        return getLeafSize(root.left)+getLeafSize(root.right);

    }


    /**
     * @name: getKLevelSize
     * @description: TODO
     * @param root
     * @return: int
     *
    */
    public int getKLevelSize(TreeNode root,int k){
        if(root==null)
            return 0;
        else if(k==1){
            return 1;
        }

        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }


    /**
     * @name: find
     * @description: 查找，依次在二叉树的根、左子树、右子树中查找value，找到返回节点，否则返回null
     * @param root
     * @param value
     * @return: com.yimm.tree.TestBinaryTree.TreeNode
     *
    */
    TreeNode find(TreeNode root,int value){
        if(root==null)
            return null;

        if(root.value==value)
            return root;

        //此处应用节点存储找到的树节点
        TreeNode ret=find(root.left,value);
        if(ret!=null)
            return ret;
        else{
            ret=find(root.left,value);
        }

        return ret;
    }




    /**
     * @name: height
     * @description: 求二叉树的高度
     * @param root
     * @return: int
     *
    */
    int height(TreeNode root) {
        if (root == null)
            return 0;
        else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }


    /**
     * @name: binaryTreeComplete
     * @description: 判断是否为完全二叉树  运用队列思想
     * @param root
     * @return: int
     *
    */
    boolean binaryTreeComplete(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root!=null)
            queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode top=queue.poll();
            if(top!=null) {
                queue.offer(top.left);
                queue.offer(top.right);
            }else {
                break;
            }

        }

        while(!queue.isEmpty()){
            if(queue.poll()!=null)
                return false;
        }
        return true;
    }



    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    /**
     * @name: isBalanced
     * @description: 判断是否为平衡二叉树
     * @param root
     * @return: boolean
     *
    */
    public boolean isBalanced(TreeNode root) {
        if(root ==null)
            return true;
        else{
            //首先计算root是否为平衡二叉树
            int left=maxDepth(root.left);
            int right=maxDepth(root.right);
            return Math.abs(left-right)<2 &&
                    isBalanced(root.left) &&
                    isBalanced(root.right);
        }
    }


    /**
     * @name: isSymmetric
     * @description: 对称二叉树
     * @param root
     * @return: boolean
     *
    */
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSymmetricChild(root.left,root.right);
    }

    public boolean isSymmetricChild(TreeNode left,TreeNode right){
        if(left==null && right==null)
            return true;
        if(left==null || right==null)
            return false;
        //此时left和right都不为空
        return (left.value==right.value) &&
                isSymmetricChild(left.left,right.right) &&
                isSymmetricChild(left.right,right.left);
    }


    /**
     * @name: tree2str
     * @description: 采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串
     * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对
     * @param t
     * @return: java.lang.String
     *
    */
    public String tree2str(TreeNode t) {
        StringBuilder sb=new StringBuilder();
        tree2strChild(t,sb);
        return sb.toString();
    }

    public void tree2strChild(TreeNode t,StringBuilder sb){
        if(t==null)
            return;
        sb.append(t.value);
        //左子树
        if(t.left!=null){
            sb.append("(");
            //递归左边
            tree2strChild(t.left,sb);
            //左边结束加括号
            sb.append(")");
        }else{
            if(t.right==null){
               return;
            }else{
                //左子树为空右子树不为空
                sb.append("()");
            }
        }

        //右子树
        if(t.right==null)
            return;
        else{
            sb.append("(");
            tree2strChild(t.right,sb);
            sb.append(")");
        }
    }



    /**
     * @name: lowestCommonAncestor
     * @description: 最近公共祖先，关键点在于先找到的目标节点为公共祖先
     * @param root
     * @param p
     * @param q
     * @return: com.yimm.tree.TestBinaryTree.TreeNode
     *
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        //传入的root为所求两个节点之一则其为最近公告祖先,最先找到的节点为最近公共祖先
        if(root==p || root==q)
            return root;

        TreeNode leftTree=lowestCommonAncestor(root.left,p,q);
        //此时返回p或q   ||null
        TreeNode rigthtTree=lowestCommonAncestor(root.right,p,q);
        //此时返回p或q   ||null

        //两个节点一左一右
        if(leftTree!=null && rigthtTree!=null)
            return root;
            //两个节点都在左边
        else if(leftTree!=null)
            return leftTree;
            //两个节点都在右边
        else if(rigthtTree!=null)
            return rigthtTree;
        else
            return null;
    }

}
