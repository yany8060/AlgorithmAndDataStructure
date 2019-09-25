package com.yany.datastructures.tree;

/**
 * Created by yanyong on 2016/12/14.
 */
public class TreeNode {
    private int key;
    private int high;
    private String data = null;
    private boolean isVisted = false;
    private TreeNode leftChild = null;
    private TreeNode rightChild = null;

    public TreeNode() {
    }

    public TreeNode(String data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * @param key  层序编码
     * @param data 数据域
     */
    public TreeNode(int key, String data) {
        this.key = key;
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
