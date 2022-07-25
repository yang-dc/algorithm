package com.xckk.primary;

/**
 * 双端队列
 *
 * @param <V>
 */
public class MyDoubleQueue<V> {

    private int size;
    private DoubleNode<V> head;
    private DoubleNode<V> tail;

    public MyDoubleQueue() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public int getSize() {
        return size;
    }
    // 前加
    public void offer(V value) {
        DoubleNode<V> node = new DoubleNode<>(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.last = node;
            head = node;
        }
        size ++;
    }

    // 后加
    public void add(V value) {
        DoubleNode<V> node = new DoubleNode<>(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.last = tail;
            tail = node;
        }
        size ++;
    }
    // 前取
    public V poll() {
        V ans = null;

        if (head != null) {
            ans = head.value;
            head = head.next;
            head.last = null;
            size --;
        }

        return ans;
    }

    // 后取
    public V get() {
        V ans = null;

        if (tail != null) {
            ans = tail.value;
            tail = tail.last;
            tail.next = null;
            size--;
        }
        return ans;
    }

}
