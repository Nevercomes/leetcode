import java.util.List;

/**
 * 单链表的反转
 *
 * @author Sunss
 * @since 2021/3/31
 */
class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode prev = head;

        ListNode node = prev.next;
        prev.next = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        printLinkedList(head);
        printLinkedList(solution.reverseList(head)); // 3 2 1 0
//        printLinkedList(solution.reverseList(node1)); // 3 2 1
//        printLinkedList(solution.reverseList(node2)); // 3 2
//        printLinkedList(solution.reverseList(node3)); // 3
        printLinkedList(null);
    }

    public static void printLinkedList(ListNode node) {
        if (node == null) System.out.print("print node is null!");
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
