/**
 * @author Sunss
 * @since 2021/4/3
 */

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // leetcode的第二题？
        // 可能超内存了，那就不new节点了，两个都用来保存答案
        ListNode ansHead = new ListNode(0); // 答案的哑节点
        ListNode ansNode = ansHead;
        ListNode node1 = l1, node2 = l2;
        int q = 0;
        while (node1 != null && node2 != null) {
            int temp = node1.val + node2.val + q;
            int cur = temp % 10;
            q = temp / 10;

            ListNode curNode = new ListNode(cur);
            ansNode.next = curNode;
            ansNode = curNode;

            node1 = node1.next;
            node2 = node2.next;
        }

        if (q == 1 && node1 == null && node2 == null) {
            ListNode node = new ListNode(1);
            ansNode.next = node;
            ansNode = node;
        }

        while (node1 != null) {
            int temp = node1.val + q;
            int cur = temp % 10;
            q = temp / 10;

            ListNode curNode = new ListNode(cur);
            ansNode.next = curNode;
            ansNode = curNode;

            node1 = node1.next;
        }

        while (node2 != null) {
            int temp = node2.val + q;
            int cur = temp % 10;
            q = temp / 10;

            ListNode curNode = new ListNode(cur);
            ansNode.next = curNode;
            ansNode = curNode;

            node2 = node2.next;
        }
//        print(ansHead.next);
        return ansHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void print(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);

        ListNode r1 = new ListNode(5);
        ListNode r2 = new ListNode(6);
        ListNode r3 = new ListNode(4);
        ListNode r4 = new ListNode(8);
        l1.next = l2;
        l2.next = l3;

        r1.next = r2;
        r2.next = r3;
        r3.next = r4;

        Solution solution = new Solution();
        solution.addTwoNumbers(l1, r1);

    }
}
