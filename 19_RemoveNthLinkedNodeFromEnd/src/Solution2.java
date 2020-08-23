/**
 * 使用哑节点，两趟遍历
 * @author Sunss
 * @since 2020/8/23
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
}

public class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 初始化哑节点,防止head被删除了，不需要特判head为null的情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = head;
        int length = 0;
        // 首次遍历获取链表的长度 L
        while (node != null) {
            length++;
            node = node.next;
        }
        // 定位到正序的位置
        length -= n;
        node = dummy;
        while (length-- > 0) {
            node = node.next;
        }
        node.next = node.next.next;
        return dummy.next;
    }
}
