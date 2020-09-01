/**
 * 题目：给定一个代表分数的数组，玩家1，2分别可以从两端选取，判断玩家1是否会赢
 * 思路：最直接的方式就是递归，判断1是否能赢就是 1的分数减去2的分数大于等于0
 * 优化：记住递归中那些重复的计算
 *
 * @author Sunss
 * @since 2020/9/1
 */
class Solution {

    public boolean PredictTheWinner(int[] nums) {

        int[][] memo = new int[nums.length][nums.length];

        return total(nums, 0, nums.length - 1, 1, memo) >= 0;
    }

    public int total(int[] nums, int start, int end, int turn, int[][] memo) {
        if (memo[start][end] != 0) return memo[start][end];
        if (start == end) {
            memo[start][end] = nums[start] * turn;
            return nums[start] * turn;
        }
        int scoreStart = nums[start] * turn + total(nums, start + 1, end, -turn, memo);
        int scoreEnd = nums[end] * turn + total(nums, start, end - 1, -turn, memo);
        memo[start][end] =  Math.max(scoreStart * turn, scoreEnd * turn) * turn;
        return memo[start][end];
    }
}
