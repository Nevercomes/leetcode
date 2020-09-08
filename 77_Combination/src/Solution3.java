import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 思路：使用是不是用这个数来进行剪枝，其实这是遍历方式都改变了
 * @author Sunss
 * @since 2020/9/8
 */
public class Solution3 {
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

        // 代表后面的数已经不够用了
        if (begin > n - k + 1) {
            return;
        }

        // 不选择当前数
        dfs(n, k, begin + 1, path, res);

        // 选择当前数
        path.addLast(begin);
        dfs(n, k - 1, begin + 1, path, res); // k代表的是还有多少个数需要选
        path.removeLast();
    }
}
