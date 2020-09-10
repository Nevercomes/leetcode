import java.util.*;

/**
 * 题目：给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
 * 思路：经典回溯 + 剪枝
 * 优化：先排序再剪枝
 *
 * @author Sunss
 * @since 2020/9/9
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        // 排序之后之后如果当前数不被选入，更大的数也不会被选
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, target, path, res);
        return res;
    }

    public void dfs(int[] candidates, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 理解begin的涵义，目的是按照顺序来选取，不会出现重复的情况
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);
            // 可重复使用，所以起点依旧是i
            dfs(candidates, i, target - candidates[i], path, res);
            path.removeLast();
        }
    }
}
