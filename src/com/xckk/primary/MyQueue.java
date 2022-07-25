package com.xckk.primary;

public class MyQueue<V> {
    private int size;
    private Node<V> head;
    private Node<V> tail;

    public MyQueue() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public int getSize(){
        return size;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }

    public void offer(V value) {
        Node<V> node = new Node<>(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size ++;
    }
    // 弹出
    public V poll() {
        V ans = null;
        if (tail != null) {
            ans = head.value;
            head = head.next;
            size --;
        }

        if (head == null) {
            tail = null;
        }

        return ans;
    }

    // 获取当前要弹出的结果
    public V peek() {
        V ans = null;
        if (head != null) {
            ans = head.value;
        }

        return ans;
    }


    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();
        System.out.println(queue.getSize());
        for (int i = 0; i < 10; i++) {
            queue.offer(String.valueOf(i));
        }

        for (int i = 0; i < 11; i++) {
            System.out.println("queue.poll() = " + queue.poll());
        }


        System.out.println(queue.getSize());
    }
}
