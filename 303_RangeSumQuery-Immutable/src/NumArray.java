/**
 * 计算区间和，而 对于 区间 [i,j]的和，相当于是 [0,j] - [0,i-1] 的差值
 * 所以这是一道前缀和的例题
 * 时间复杂度为 O(n)， 空间复杂度为 O(n)
 *
 * @author Sunss
 * @since 2021/3/28
 */
public class NumArray {

    private final int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) return sums[right];
        else return sums[right] - sums[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
