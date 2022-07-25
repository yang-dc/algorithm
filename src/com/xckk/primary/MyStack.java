package com.xckk.primary;

/**
 * 先进后出
 *
 * @param <V>
 */
public class MyStack<V> {
    private int size;
    private Node<V> head;

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
        } else {
            node.next = head;
            head = node;
        }
        size ++;
    }
    // 弹出
    public V poll() {
        V ans = null;
        if (head != null) {
            ans = head.value;
            head = head.next;
            size --;
        }

        if (head == null) {
            head = null;
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
        MyStack<String> stack = new MyStack<>();
        for (int i = 0; i < 10; i++) {
            stack.offer(String.valueOf(i));
        }
        System.out.println(stack.getSize());

        for (int i = 0; i < 11; i++) {
            System.out.println("stack.poll() = " + stack.poll());
        }
        stack.offer("111");


        System.out.println(stack.getSize());
    }
}
