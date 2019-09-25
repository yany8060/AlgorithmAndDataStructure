package com.yany.datastructures.tree.btree;

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

}
