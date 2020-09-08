import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 思路：对dfs问题进行剪枝，很多分支的搜索没有必要执行下去
 * 剪枝：
 * 1 搜索起点剪枝 搜索起点的上界 + 接下来要选择的元素个数 - 1 = n
 *
 * @author Sunss
 * @since 2020/9/8
 */
public class Solution2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        // 防止动态扩容
        Deque<Integer> path = new ArrayDeque<>(k); // Deque在Java里的意思就是反的队列，也就是栈
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n - k + path.size() + 1; i++) {
            path.addLast(i);
            dfs(n, k, i + 1, path, res);
            path.removeLast();
        }
    }
}
