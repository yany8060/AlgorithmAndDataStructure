package com.yany.datastructures;

/**
 * @author yanyong on 2019/3/6
 */
public class BTree {


    class Node {
        private String data = null;
        private boolean isVisted = false;
        private Node leftChild = null;
        private Node rightChild = null;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public boolean isVisted() {
            return isVisted;
        }

        public void setVisted(boolean visted) {
            isVisted = visted;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }



}
