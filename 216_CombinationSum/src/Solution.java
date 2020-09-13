import java.util.*;

/**
 * 题目：找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 思路：和combination sum 1 combination sum 2的思路是一样的
 *
 * @author Sunss
 * @since 2020/9/11
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        // 排序，为一大一小两步剪枝做准备
        Deque<Integer> path = new ArrayDeque<>();
        dfs(k, 1, n, path, res);
        return res;
    }

    public void dfs(int k, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k || target <= 0) {
            if (path.size() == k && target == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        // 和2，3一样，这就是一颗九叉树
        for (int i = begin; i <= 9; i++) {
            path.addLast(i);
            dfs(k, i + 1, target - i, path, res);
            path.removeLast();
        }
    }

}
