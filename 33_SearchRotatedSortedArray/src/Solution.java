/**
 * 题目：给定一个根据某点旋转后的数组
 * 要求，时间复杂度为 logn
 * 思路：二分搜索，有一段必然有序
 *
 * @author Sunss
 * @since 2020/8/25
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return target == nums[0] ? 0 : -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) { // 左边有序,注意这里不是 l
                if (nums[0] <= target && nums[mid] > target) { // 表示数在左区间段
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else { // 右边有序
                if (nums[nums.length - 1] >= target && nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
