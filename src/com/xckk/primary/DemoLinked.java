package com.xckk.primary;
//git@github.com:yang-dc/algorithm.git
public class DemoLinked {

    static class DoubleNode<V> {
        public V value;
        public DoubleNode<V> next;
        public DoubleNode<V> last;

        public DoubleNode(V value) {
            this.value = value;
        }
    }

    public static Node<Integer> prepareLinked(int num) {
        Node<Integer> node = new Node<>(0);
        Node<Integer> next = node;
        for (int i = 1; i < num; i++) {
            next.next = new Node<>(i);
            next = next.next;
        }
        return node;
    }

    public static void printNode(Node<Integer> node) {
        System.out.println();
        while (node != null) {
            System.out.print(node.value + "\t");
            node = node.next;
        }
    }
    private static void printNode(DoubleNode<Integer> node) {
        System.out.println();
        while (node != null) {
            System.out.print(node.value + "\t");
            node = node.next;
        }
    }

    public static void testLinked(int num) {
        Node<Integer> node = prepareLinked(num);
        printNode(node);
        Node node1 = linkedReverse(node);
        printNode(node1);
    }

    private static Node linkedReverse(Node<Integer> node) {
        Node<Integer> next = null;
        Node<Integer> pre = null;
        for(;;) {
            next = node.next;
            node.next = pre;
            pre = node;
            if (next != null) {
                node = next;
            } else {
                break;
            }
        }
        return node;
    }


    public static void main(String[] args) {
        testLinked(10);

        testDoubleLinked(10);

    }

    private static void testDoubleLinked(int num) {
        DoubleNode<Integer> doubleNode = prepareDoubleLinked(num);
        printNode(doubleNode);
        doubleNode = doubleLinkedReverse(doubleNode);
        printNode(doubleNode);
    }

    private static DoubleNode<Integer> doubleLinkedReverse(DoubleNode<Integer> doubleNode) {

        DoubleNode pre = null;
        DoubleNode next = null;
        for(;;) {
            next = doubleNode.next;
            doubleNode.next = pre;
            doubleNode.last = next;
            pre = doubleNode;
            if (next != null) {
                doubleNode = next;
            } else {
                break;
            }
        }
        return doubleNode;
    }

    private static DoubleNode<Integer> prepareDoubleLinked(int num) {
        DoubleNode<Integer> doubleNode = new DoubleNode<>(0);
        DoubleNode<Integer> pre = null;
        DoubleNode<Integer> next = doubleNode;
        for (int i = 1; i < num; i++) {
            next.next = new DoubleNode<>(i);
            next.last = pre;
            pre = next;
            next = next.next;
        }
        next.last = pre;


        return doubleNode;
    }

}
