import java.util.*;

/**
 * 题目：求全排列，数组有重复元素，给出的全排列不可以重复
 * 思路：dfs + 剪枝，先对原数字进行排序
 * @author Sunss
 * @since 2020/9/18
 */
public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0) return res;

        Arrays.sort(nums);

        boolean[] used = new boolean[len];
        Deque<Integer> path = new LinkedList<>();
        dfs(nums, len, 0, used, path, res);

        return res;
    }

    public void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, used, path, res);

            used[i] = false;
            path.removeLast();

        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permuteUnique(nums);
        System.out.println(lists);
    }

}
