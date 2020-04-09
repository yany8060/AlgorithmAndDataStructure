package com.yany.datastructures.list;

/**
 * @author yanyong on 2019/11/20
 */
public class SkipList {
    private static final float SKIPLIST_P = 0.5f;
    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;

    /**
     * 带头链表
     */
    private Node head = new Node();


    public void insert(int value) {
        int level = randomLevel();


    }


    public int randomLevel() {
        int level = 1;
        while (Math.random() < SKIPLIST_P && level <= MAX_LEVEL) {
            level++;
        }
        return level;
    }


    public class Node {
        private int data = -1;
        private Node forwards[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }

}
