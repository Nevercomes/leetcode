import java.util.*;

/**
 * 思路：桶排序，一样的hashmap统计频度，选取最大的k个元素的时候用出现次数作为下标，最后反向遍历k项即可
 * 最坏的情况需要一个额外的 o(n)的存储空间
 *
 * @author Sunss
 * @since 2020/9/7
 */
public class Solution2 {
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

        List<Integer> res = new ArrayList();

        List<Integer>[] list = new List[nums.length + 1]; // 泛型数组
        for (int key : map.keySet()) {
            // 获取出现的次数作为下标
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
        for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
            if (list[i] == null) continue;
            res.addAll(list[i]); // 这里利用了答案唯一性
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
