package com.yany.datastructures.tree.btree;

/**
 * @author yanyong on 2019/9/25
 */
public class BTreeLeaf<K extends Comparable<K>> extends AbstractBTreeNode<K> {
    private final Object[] keys;
    private int nkey;

    BTreeLeaf(int degree) {
        super(degree);
        // 2 * degree - 1 节点最大个数
        keys = new Object[2 * degree - 1];
    }

}
