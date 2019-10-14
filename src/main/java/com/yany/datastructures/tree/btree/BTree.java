package com.yany.datastructures.tree.btree;

/**
 * @author yanyong on 2019/9/25
 */
public class BTree<K extends Comparable<K>> {

    private final int degree;

    private AbstractBTreeNode<K> root;

    public BTree(int degree) {
        if (degree < 2) {
            throw new IllegalArgumentException("degree mustn't < 2");
        }
        this.degree = degree;
        root = new BTreeLeaf<>(degree);
    }

    public AbstractBTreeNode<K> getRoot() {
        return root;
    }

    public void insert(K key) {
        AbstractBTreeNode<K> n = root;
        if (root.isFull()) {
            AbstractBTreeNode<K> newRoot = new BTreeInternalNode<>(degree);


        }
        n.insertNotFull(key);

    }


}
