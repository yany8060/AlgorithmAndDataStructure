package com.yany.datastructures.tree.btree;

/**
 * @author yanyong on 2019/9/25
 */
public abstract class AbstractBTreeNode<K extends Comparable<K>> {

    /**
     * b-树的最小度数
     */
    protected final int degree;

    AbstractBTreeNode(int degree) {
        if (degree < 2) {
            throw new IllegalArgumentException("degree must >= 2");
        }
        this.degree = degree;
    }

    abstract boolean isLeaf();

    abstract K search(K key);

    abstract void insertNotFull(K key);


}
