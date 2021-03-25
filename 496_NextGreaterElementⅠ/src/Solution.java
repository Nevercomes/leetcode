import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 单调栈解法
 * 单调栈求的是一个数组自己 每个元素右边比自己大的第一个元素
 * 它记录的不是index，而是数字本身的对应关系，当然记index也可以，就是入栈的就不是int了，而是一个对象，不简洁
 * 时间复杂度为 O(n + m)
 *
 * @author Sunss
 * @since 2021/3/25
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }

        return res;
    }
}
