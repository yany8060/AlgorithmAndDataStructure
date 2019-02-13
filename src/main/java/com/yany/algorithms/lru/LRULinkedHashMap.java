package com.yany.algorithms.lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yanyong on 2019/2/12
 */
public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private final int maxCapacity;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Lock lock = new ReentrantLock();

    /**
     * true: 表示get() 数据放在链表头
     *
     * @param maxCapacity
     */
    public LRULinkedHashMap(int maxCapacity) {
        super(maxCapacity, DEFAULT_LOAD_FACTOR, true);
        this.maxCapacity = maxCapacity;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxCapacity;
    }

    @Override
    public V get(Object key) {
        try {
            lock.lock();
            return super.get(key);
        } finally {
            lock.unlock();
        }
    }


    @Override
    public V put(K key, V value) {
        try {
            lock.lock();
            return super.put(key, value);
        } finally {
            lock.unlock();
        }
    }
}
