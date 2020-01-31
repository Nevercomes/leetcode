/**
 * 存在new ListNode(0)的bug
 * @author: sun
 * @date: 2019/5/17
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int res = getLonger(l1, l2);
        ListNode longer, temp1, temp2;
        if (res == 1) {
            temp1 = longer = l1;
            temp2 = l2;
        } else {
            temp1 = longer = l2;
            temp2 = l1;
        }
        // 获取初始值
        int addRes = add(temp2, temp1, 0);
        if (temp2.next == null && addRes == 1 && temp1.next != null) {
            // temp1.next.val = temp1.next.val + 1;
            while (temp1.next != null) {
                temp1 = temp1.next;
                addRes = add(temp1, addRes);
                if (temp1.next == null && addRes == 1) {
                    temp1.next = new ListNode(0);
                }
            }
        } else if (temp2.next == null && temp1.next == null && addRes == 1) {
            temp1.next = new ListNode(1);
        }
        while (temp2.next != null) {
            temp2 = temp2.next;
            temp1 = temp1.next;
            addRes = add(temp2, temp1, addRes);
            if (temp1.next == null && addRes == 1) {
                temp1.next = new ListNode(0);
            }
            if (temp2.next == null && addRes == 1) {
                while (temp1.next != null) {
                    temp1 = temp1.next;
                    addRes = add(temp1, addRes);
                    if (temp1.next == null && addRes == 1) {
                        temp1.next = new ListNode(0);
                    }
                }
            }
        }
        return longer;
    }

    private int getLonger(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1.next != null) {
            temp1 = temp1.next;
            if (temp2.next == null) {
                return 1;
            }
            temp2 = temp2.next;
        }
        return 2;
    }

    /**
     * 返回进位的值 0 | 1
     *
     * @param l1
     * @param l2
     * @return
     */
    private int add(ListNode l1, ListNode l2, int a) {
        int res = l1.val + l2.val + a;
        l2.val = (l1.val + l2.val + a) % 10;
        return res / 10;
    }

    private int add(ListNode l, int a) {
        int res = l.val + a;
        l.val = (l.val + a) % 10;
        return res / 10;
    }
}
