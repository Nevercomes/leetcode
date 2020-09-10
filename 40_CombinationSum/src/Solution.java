import java.util.*;

/**
 * 题目：给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
 * 限制：数组中的数只能使用一次
 * 思路：经典回溯 + 剪枝
 *
 * @author Sunss
 * @since 2020/9/9
 */
public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        // 排序，为一大一小两步剪枝做准备
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, target, path, res);
        return res;
    }

    public void dfs(int[] candidates, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 理解begin的涵义，目的是按照顺序来选取，不会出现重复的情况
        for (int i = begin; i < candidates.length; i++) {
            // 因为排序后所以可以这样子剪枝
            if (target - candidates[i] < 0) {
                break;
            }
            // 为了避免重复的重要剪枝，这里的i > begin 很重要，它代表了可以不同层出现相同的元素
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue; // 跳过同层的相同元素
            }
            path.addLast(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], path, res);
            path.removeLast();
        }
    }
}
