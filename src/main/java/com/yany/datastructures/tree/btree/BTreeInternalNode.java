package com.yany.datastructures.tree.btree;

import java.util.Arrays;

/**
 * @author yanyong on 2019/9/25
 */
public class BTreeInternalNode<K extends Comparable<K>> extends AbstractBTreeNode<K> {

    // 内部节点
    private final Object[] keys;
    // 叶子节点
    private final AbstractBTreeNode<K>[] children;
    // 内部节点数
    private int nkey = 0;
    // 叶子节点数
    private int nchild = 0;


    BTreeInternalNode(int degree) {
        super(degree);
        keys = new Object[2 * degree - 1];
        children = new AbstractBTreeNode[2 * degree];
    }

    @Override
    boolean isLeaf() {
        return false;
    }

    @Override
    K getKey(int idx) {
        return (K) keys[idx];
    }

    @Override
    protected K setKey(K newKey, int oldKeyIndex) {
        K old = (K) keys[oldKeyIndex];
        keys[oldKeyIndex] = newKey;
        return old;
    }

    @Override
    protected void setChild(AbstractBTreeNode<K> sub, int index) {
        children[index] = sub;
    }

    @Override
    AbstractBTreeNode<K> getChild(int index) {
        if (index >= 0 && index < children.length) {
            return children[index];
        }
        return null;
    }

    @Override
    protected int setNKey(int nkey) {
        int old = this.nkey;
        this.nkey = nkey;
        return old;
    }

    @Override
    int nkey() {
        return nkey;
    }

    @Override
    int nchild() {
        return nchild;
    }

    @Override
    protected int setNChild(int nchild) {
        int old = this.nchild;
        this.nchild = nchild;
        return old;
    }


    @Override
    K search(K key) {
        int index = indexOfKey(key);
        if (index >= 0) {
            return (K) keys[index];
        }
        index = 0;
        while (key.compareTo((K) keys[index++]) > 0) {

        }
        return children[index].search(key);
    }

    @Override
    void insertNotFull(K key) {
        checkNotFull();
        int i = 0;
        while (i < nkey && key.compareTo((K) keys[i]) >= 0) {
            i++;
        }

        if (this.children[i].isFull()) {
            this.splitChild(i);
            if (key.compareTo((K) this.keys[i]) > 0) {
                i++;
            }
        }

        this.children[i].insertNotFull(key);
    }

    @Override
    void deleteNotEmpty(K key) {
        if (this.existsKey(key)) {
            //key in this node

            int index = indexOfKey(key);
            AbstractBTreeNode<K> node;
            if ((node = children[index]).nkey() >= degree) {
                K repKey = node.getKey(node.nkey() - 1);
                node.deleteNotEmpty(repKey);
                setKey(repKey, index);
            } else if ((node = children[index + 1]).nkey() >= degree) {
                K repKey = node.getKey(0);
                node.deleteNotEmpty(repKey);
                setKey(repKey, index);
            } else {
                node = children[index];
                node.merge(key, children[index + 1]);
                this.deleteKey(index);
                this.deleteChild(index + 1);
                node.deleteNotEmpty(key);
            }
        } else {
            //key may exist in child
            int i = 0;
            while (i < nkey()) {
                if (key.compareTo((K) keys[i]) < 0) {
                    break;
                }
            }
            AbstractBTreeNode<K> target = children[i];
            if (target.nkey() >= degree) {
                target.deleteNotEmpty(key);
            } else {
                //try to find replacement from predecessor
                AbstractBTreeNode<K> sibling;
                if (i > 0 && (sibling = children[i - 1]).nkey() >= degree) {
                    if (!target.isLeaf()) {
                        AbstractBTreeNode<K> sub = sibling.deleteChild(nchild);
                        target.insertChild(sub, 0);
                    }
                    K repKey = sibling.deleteKey(sibling.nkey() - 1);
                    repKey = setKey(repKey, i - 1);
                    target.insertKey(repKey);
                    target.deleteNotEmpty(key);
                } else if (i < nkey && (sibling = children[i + 1]).nkey() >= degree) {

                }

            }

        }
    }

    @Override
    protected void splitChild(int child) {


    }

    @Override
    protected void merge(K middle, AbstractBTreeNode<K> sibling) {
        if (!(sibling instanceof BTreeInternalNode)) {
            throw new RuntimeException("Sibling is not leaf node");
        }

        BTreeInternalNode node = (BTreeInternalNode) sibling;
        this.insertKey(middle);
        for (int i = 0; i < node.nkey(); i++) {
            this.insertKey((K) node.keys[i]);
        }
        for (int i = 0; i < node.nchild(); i++) {
            insertChild(node.children[i], i + degree);
        }


    }
}
