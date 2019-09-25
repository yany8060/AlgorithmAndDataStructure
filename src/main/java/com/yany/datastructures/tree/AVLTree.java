package com.yany.datastructures.tree;

/**
 * 二叉平衡树-AVL
 *
 * @author yanyong on 2019/3/20
 */
public class AVLTree {


    private TreeNode leftLeftRotate(TreeNode x) {
        TreeNode w = x.getLeftChild();
        w.setLeftChild(w.getRightChild());
        w.setRightChild(x.getLeftChild());




        return null;
    }


}
