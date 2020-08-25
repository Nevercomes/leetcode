/**
 * 题目：在一个升序数组上，给定一个目标值，找到这个目标值的区间范围
 * 要求：时间复杂度为 logn
 * 思路：二分，细节依旧折磨人
 *
 * @author Sunss
 * @since 2020/8/25
 */
public class Solution {

    /**
     * @param left 是否找左边界
     * @return
     */
    private int mostIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length; // 1.这里hi的取值都是有讲究的

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid; // 2. 1和2结合可以让left为true的时候不断向左遍历（2分的方式）
            } else {
                lo = mid + 1; // 2分的细节总是很难考虑的...
            }
        }

        return lo;
    }


    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int l = mostIndex(nums, target, true);
        if (l == nums.length || nums[l] != target) {
            return res;
        }
        res[0] = l;
        res[1] = mostIndex(nums, target, false) - 1;
        return res;
    }
}
