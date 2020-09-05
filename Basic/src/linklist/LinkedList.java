package linklist;

import java.util.List;

/**
 * 1 单链表反转
 * 2 链表中的环检测
 * 3 两个有序链表的合并
 * 4 删除链表倒数第n个节点
 * 5 求链表的中间节点
 *
 * @author Sunss
 * @since 2020/9/5
 */

class Node {
    public int data;
    public Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class LinkedList {

    // 1 单链表反转
    public static Node reverse(Node head) {
        Node cur = head, pre = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre; // pre是反转之后的头节点
    }

    // 2 检测环
    public static boolean checkCircle(Node head) {
        if (head == null) return false;
        Node fast = head.next;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // 3 有序链表合并
    public static Node mergeTwoList(Node n1, Node n2) {
        Node dummy = new Node(-1, null); // 引入哑节点，也叫哨兵机制
        Node p = dummy;
        while (n1 != null && n2 != null) {
            if (n1.data < n2.data) {
                p.next = n1;
                n1 = n1.next;
            } else {
                p.next = n2;
                n2 = n2.next;
            }
            p = p.next;
        }
        p.next = n1 == null ? n2.next : n1.next;
        return dummy.next;
    }

    // 4 删除倒数第K个结点
    public static Node deleteKthNode(Node head, int k) {
        Node pioneer = head; // 先驱节点
        int i = 1; // 这里注意计数，边界问题就是这样，多测试，多考虑，然后你就记住了
        while (pioneer != null && i < k) {
            pioneer = pioneer.next;
            i++;
        }
        if (pioneer == null) return head;

        Node post = head; // 后置节点
        Node pre = null; // 用来保存那个被删掉节点的前一个节点
        while (pioneer.next != null) {
            pioneer = pioneer.next;
            pre = post;
            post = post.next;
        }
        if (pre == null) { // pre为null的情况只有pioneer.next是null，也就是说pioneer遍历到了最后一个节点，k此时为n
            head = head.next;
        } else {
            pre.next = pre.next.next;
        }
        return head;
    }

    // 5 找中间节点
    public static Node findMiddleNode(Node head) {
        if (head == null) return null;
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void PrintAll(Node head) {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(0, null);
        Node p = head;
        for (int i = 1; i < 10; i++) {
            Node node = new Node(i, null);
            p.next = node;
            p = node;
        }
        PrintAll(head);
        PrintAll(findMiddleNode(head));
        PrintAll(deleteKthNode(head, 9));
    }

}
