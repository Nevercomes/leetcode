/**
 * 爬楼梯，n阶楼梯，可以爬 1或者2 步
 * 问总共有几种爬法
 * 最基础的动态规划问题，也是分治策略
 * 时间复杂度 O(n)，空间复杂度 O(n),可以优化为 O(1)
 *
 * @author Sunss
 * @since 2021/3/28
 */
public class Solution {
    public int climbStairs(int n) {
        int[] f = new int[n + 1];
        if (n == 1) return 1;
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
