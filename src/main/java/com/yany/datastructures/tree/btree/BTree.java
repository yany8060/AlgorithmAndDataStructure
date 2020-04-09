package com.yany.datastructures.tree.btree;

/**
 * https://blog.csdn.net/kalikrick/article/details/27980007
 *
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
            newRoot.insertChild(n, 0);
            newRoot.splitChild(0);
            n = newRoot;
            root = newRoot;
        }
        n.insertNotFull(key);
    }


    public void delete(K key) {
        AbstractBTreeNode<K> node = root;
        node.deleteNotEmpty(key);
        if (node.nkey() == 0) {
            root = node.getChild(0);
            if (root == null) {
                root = new BTreeLeaf<K>(degree);
            }
        }
    }

    public K search(AbstractBTreeNode<K> node, K key) {
        int i = node.indexOfKey(key);
        if (i > 0) {
            return node.getKey(i);
        }
        i = 0;
        while (i < node.nkey() && key.compareTo(node.getKey(i)) > 0) {
            i++;
        }

        return null;
    }

    @Override
    public String toString() {
        return AbstractBTreeNode.BTreeToString(this.root);
    }

    public static void main(String[] args) {
        System.getSecurityManager();


    }
}
