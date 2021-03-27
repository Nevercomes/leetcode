/**
 * 给定一个数组，求其最大子序列和
 * 一道简单的动态规划问题，f(i) = max{f(i-1)+nums[i], nums[i]}
 * 时间复杂度为 O(n)，空间复杂度为 O(1)
 *
 * @author Sunss
 * @since 2021/3/28
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int ans = -100000;
        int pre = -100000;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(pre, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-10000};
        System.out.println(solution.maxSubArray(nums));
    }
}
