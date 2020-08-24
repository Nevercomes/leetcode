/**
 * 题目：合并两个有序链表
 * 思路：基础题，很简单的归并排序
 *
 * @author Sunss
 * @since 2020/8/23
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int x) {
        this.val = x;
    }
    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);

        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return dummy.next;
    }


}
