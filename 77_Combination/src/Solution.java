import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 题目：给定n，k求所有的组合数
 * 思路：回溯，dfs，树上的搜索
 * @author Sunss
 * @since 2020/9/8
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        // 从 1 开始是题目的设定
        Deque<Integer> path = new ArrayDeque<>(); // Deque在Java里的意思就是反的队列，也就是栈
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            dfs(n, k, i + 1, path, res);
            path.removeLast();
        }
    }

}
