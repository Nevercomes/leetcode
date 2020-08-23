/**
 * 题目：删除链表的倒数第N个节点，使用一趟扫描实现
 * 思路：倒着数是n，正着数就是 L-n
 * @author Sunss
 * @since 2020/8/23
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 初始化哑节点,防止head被删除了，不需要特判head为null的情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // 第一个指针从头开始遍历n个节点，如果从head开始的话就是 i<n,这是为了second可以停在l-n-1的位置上
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        // 第二圈两个一起开始，正序 l-n 就是 倒序n
        while (first != null) {
            first = first.next;
            second = second.next; // 当跳出循环的时候 second到达的是 l-n-1的位置
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
