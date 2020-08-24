/**
 * 题目：算法需要将给定数字序列重新排列成字典序中下一个更大的排列，若已经是最大排列，则变为最小排列
 * 要求：必须原地修改，只允许使用额外常数空间。
 * 思路：基础题，直接学习就可以了，从后向前遍历找到 a[i]>a[j]，在从后遍历找到a[k]>a[j]，交换k、j，改交换后i到end部分为升序
 * @author Sunss
 * @since 2020/8/24
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len <= 1) return;
        // 从后向前遍历,找到a[i]>a[j]
        int i = len - 1, j = len - 2;
        while (j >= 0 && nums[i] <= nums[j]) {
            i--;
            j--;
        }
        // 不是最后一个排列，则去找到a[j]<a[k]
        if (j >= 0) {
            int k = len - 1;
            while (nums[j] >= nums[k]) {
                k--;
            }
            // 交换k，j的数字
            int temp = nums[j];
            nums[j] = nums[k];
            nums[k] = temp;
        }
        // 此时i到end的部分必然是降序，改变为升序
        j = len - 1;
        while (i < j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
    }
}
