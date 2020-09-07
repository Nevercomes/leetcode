import java.util.*;

/**
 * 题目：给定一个非空的整数数组，返回其中出现频率前 k 高的元素
 * 思路：Hash表统计数字的出现次数，推排序确定前k个元素，这里是用最小堆保留了k个元素
 *
 * @author Sunss
 * @since 2020/9/7
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 统计数字的出现次数，用hashmap保存
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 遍历map，用最小堆来保存最大的k个元素，这里借助优先队列，不需要自己实现最小堆了
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2); // 升序排序，最小的优先级最高
            }
        });
        for (Integer key : map.keySet()) {
            if (pq.size() < k) { // 直接加入
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                // 移除最小的key，加入这个比它大的值
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.remove();
        }
        return res;
    }
}
