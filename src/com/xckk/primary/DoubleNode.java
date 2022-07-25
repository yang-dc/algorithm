package com.xckk.primary;

public class DoubleNode<V> {
    public V value;
    public DoubleNode<V> next;
    public DoubleNode<V> last;

    public DoubleNode(V value) {
        this.value = value;
    }
}
