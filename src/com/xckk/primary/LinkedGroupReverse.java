package com.xckk.primary;

public class LinkedGroupReverse {

    // 查询下一组的前一个节点
    // 1    2   3   4   5   6   7   8  9
    // returns 4 不够不处理
    public static Node getNext(Node start, int num) {
        while (--num != 0 && start != null) {
            start = start.next;
        }
        return start;
    }
    public static void reverse(Node start, Node end) {
        end = end.next;
        Node pre = null;
        Node next = null;
        Node cur = start;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    public static void main(String[] args) {

        testLinkedGroupReverse();
    }

    private static void testLinkedGroupReverse() {
        Node<Integer> node = DemoLinked.prepareLinked(10);
        DemoLinked.printNode(node);
        System.out.println();


//      0	1	2	3	4	5	6	7	8	9
//      3个一组
//      2   1   0  |  5   4   3 |  8   7   6 |  9
        int num = 3;    // 三组
        node = linkedGroupReverse(node, num);

        DemoLinked.printNode(node);

    }

    private static Node<Integer> linkedGroupReverse(Node<Integer> head, int num) {
        Node start = head;
        Node end = getNext(start, num);
        if (end != null) {  // 0, 1, null
            return head;
        }
        // 小组凑齐了
        head = end;
        reverse(start, end);
        // 上一组的节点位置
        Node lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getNext(start, num);
            if (end ==null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }
}
