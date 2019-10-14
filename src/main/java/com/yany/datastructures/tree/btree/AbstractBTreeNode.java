package com.yany.datastructures.tree.btree;

import java.util.LinkedList;
import java.util.Queue;

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

    abstract void deleteNotEmpty(K key);

    void insertKey(K key) {
        checkNotFull();
        int i = this.nkey();
        //move keys
        while (i > 0 && key.compareTo(this.getKey(i - 1)) < 0) {
            this.setKey(this.getKey(i - 1), i);
            i--;
        }
        this.setKey(key, i);
        this.setNKey(this.nkey() + 1);
    }

    /**
     * 获取节点中的元素
     *
     * @param idx
     * @return
     */
    abstract K getKey(int idx);


    /**
     * 删除当前节点中的元素
     *
     * @param key
     * @return
     */
    protected K deleteKey(K key) {
        int index = indexOfKey(key);
        if (index >= 0) {
            return this.deleteKey(index);
        }
        return null;
    }

    /**
     * 删除当前节点中的元素
     *
     * @param index
     * @return
     */
    protected K deleteKey(int index) {
        if (index < 0 || index >= this.nkey()) {
            throw new RuntimeException("Index is invalid.");
        }
        K result = this.getKey(index);
        while (index < this.nkey() - 1) {
            this.setKey(this.getKey(index + 1), index);
            index++;
        }
        this.setKey(null, this.nkey() - 1);
        this.setNKey(this.nkey() - 1);
        return result;
    }

    /**
     * key存在校验
     *
     * @param key
     * @return
     */
    boolean existsKey(K key) {
        return indexOfKey(key) >= 0;
    }

    /**
     * 替换元素
     *
     * @param oldKey
     * @param newKey
     */
    protected void replaceKey(K oldKey, K newKey) {
        int index = indexOfKey(oldKey);
        if (index >= 0) {
            setKey(newKey, index);
        }
    }


    /**
     * 设置节点中的元素
     *
     * @param newKey
     * @param oldKeyIndex
     * @return
     */
    protected abstract K setKey(K newKey, int oldKeyIndex);


    /**
     * 设置子节点
     *
     * @param sub
     * @param index
     */
    protected abstract void setChild(AbstractBTreeNode<K> sub, int index);


    /**
     * 插入子节点
     *
     * @param sub
     * @param index
     */
    protected void insertChild(AbstractBTreeNode<K> sub, int index) {
        int i = this.nchild();
        while (i > index) {
            // 节点后移
            this.setChild(this.getChild(i - 1), i);
            i--;
        }
        this.setChild(sub, index);
        this.setNChild(this.nchild() + 1);
    }

    /**
     * 获取子节点
     *
     * @param index
     * @return
     */
    abstract AbstractBTreeNode<K> getChild(int index);


    protected void deleteChild(AbstractBTreeNode<K> child) {
        int index = -1;
        for (int i = 0; i < nchild(); i++) {
            if (this.getChild(i) == child) {
                index = 1;
                break;
            }
        }
        if (index >= 0) {
            deleteChild(index);
        }
    }

    protected AbstractBTreeNode<K> deleteChild(int index) {
        AbstractBTreeNode<K> result = null;
        if (index >= 0 && index < this.nchild()) {
            result = this.getChild(index);
            while (index < this.nchild() - 1) {
                this.setChild(this.getChild(index + 1), index);
                index++;
            }
            this.setChild(null, index);
            this.setNChild(this.nchild() - 1);

        }
        return result;
    }

    /**
     * 将一个满子节点拆分两个子节点
     *
     * @param child 子节点拆分位置
     */
    protected abstract void splitChild(int child);

    /**
     * 将自己拆成两个子节点
     *
     * @param newNode
     * @return
     */
    protected abstract K splitSelf(AbstractBTreeNode<K> newNode);

    /**
     * 合并节点
     *
     * @param middle
     * @param sibling
     */
    protected abstract void merge(K middle, AbstractBTreeNode<K> sibling);

    /**
     * 设置当前节点中元素的数量
     *
     * @param nkey
     * @return
     */
    protected abstract int setNKey(int nkey);


    /**
     * Child amount of current node.
     *
     * @return
     */
    abstract int nkey();

    /**
     * 当前节点的子节点数量
     *
     * @return
     */
    abstract int nchild();

    /**
     * 设置当前节点子节点数量
     *
     * @param nchild
     * @return
     */
    protected abstract int setNChild(int nchild);


    /**
     * 元素在节点的位置
     *
     * @param key
     * @return
     */
    protected int indexOfKey(K key) {
        for (int i = 0; i < this.nkey(); i++) {
            if (key.equals(this.getKey(i))) {
                return i;
            }
        }
        return -1;
    }

    protected boolean isFull() {
        return nkey() == degree * 2 - 1;
    }

    protected final void checkNotFull() {
        if (isFull()) {
            throw new RuntimeException(this.toString() + " is full.");
        }
    }


    static <K extends Comparable<K>> String BTreeToString(AbstractBTreeNode<K> root) {
        StringBuffer sb = new StringBuffer();
        AbstractBTreeNode node;
        Queue<AbstractBTreeNode> queue = new LinkedList<>();
        queue.add(root);

        String newLine = System.getProperty("line.separator");
        while (!queue.isEmpty()) {
            node = queue.poll();
            sb.append(node).append(newLine);

            int i = 0;
            while (node.getChild(i) != null) {
                queue.offer(node.getChild(i));
                i++;
            }

        }

        return sb.toString();
    }


}
