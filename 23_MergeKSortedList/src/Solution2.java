import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 思路：使用优先队列，维护所有的链表头，选取最小的元素加入优先队列
 * @author Sunss
 * @since 2020/8/24
 */
public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null; // 少了这一句 wa了两次，亏死了
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                // 升序排序
                return Integer.compare(o1.val, o2.val);
            }
        });
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        // 利用优先队列，每次选取最小的节点，插入删除的代价为 logk（二分），最多进行kn次
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if(p.next != null) queue.add(p.next);
        }
        return dummy.next;
    }
}
