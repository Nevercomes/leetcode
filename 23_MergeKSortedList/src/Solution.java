/**
 * 题目：合并k个有序的链表
 * 思路：分治，没啥好说的
 * @author Sunss
 * @since 2020/8/24
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
}

public class Solution {

    // 基础：合并两个有序链表 代表是 2n
    private ListNode mergeTwoList(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                node.next = a;
                a = a.next;
            } else {
                node.next = b;
                b = b.next;
            }
            node = node.next;
        }
        node.next = a == null ? b : a;
        return dummy.next;
    }

    // 分治的步骤 代价是 klogk
    private ListNode merge(ListNode[] lists, int l, int r) {
        if(l == r) return lists[l];
        if(l > r) return null;
        int mid = (l + r) / 2;
        return mergeTwoList(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
}
