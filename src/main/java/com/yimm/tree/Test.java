package com.yimm.tree;

/**
 * Author: sy
 * Create:2019-08-06
 * 18:03
 */
public class Test {
    public static void main(String[] args) {
        TestBinaryTree testBinaryTree=new TestBinaryTree();
        //TestBinaryTree.TreeNode treeNode=testBinaryTree.new TreeNode(2);
        TestBinaryTree.TreeNode root=testBinaryTree.createTestTree("AB##C##");

        testBinaryTree.binaryTreePrevOrder(root);
        System.out.println();
        testBinaryTree.binaryTreePrevOrderNonR(root);
        System.out.println();
        System.out.println("===================");
        testBinaryTree.binaryTreeInOrder(root);
        System.out.println();
        testBinaryTree.binaryTreeInorderNonR(root);
        System.out.println();
        System.out.println("===================");
        testBinaryTree.binaryTreePostOrder(root);
        System.out.println();
        testBinaryTree.binaryTreePostOrderNonR(root);
        System.out.println();
        System.out.println("===================");
        testBinaryTree.binaryTreeLevelOrder(root);
        System.out.println();
        System.out.println("===================");
        System.out.println("是否为完全二叉树："+testBinaryTree.binaryTreeComplete(root));
        System.out.println();
        System.out.println(testBinaryTree.getSize(root));

        System.out.println(testBinaryTree.getLeafSize(root));

        System.out.println(testBinaryTree.getKLevelSize(root,3));

        System.out.println(testBinaryTree.find(root,'B').value);

        System.out.println(testBinaryTree.height(root));
    }
}
