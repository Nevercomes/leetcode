import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：三数之和
 * 思路：哈希表（不需要直接用）、双指针
 * @author Sunss
 * @since 2020/8/22
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {// 总时间复杂度：O(n^2)
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans;

        Arrays.sort(nums); // O(nlogn)

        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            if (nums[i] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了 剪枝
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况，数字重复代表了组合重复
            int target = -nums[i]; // 蕴含哈希表的思想
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    // 现在要增加 left，减小 right，同样是不能重复的
                    left++; right--; // 首先无论如何先要进行加减操作，因为nums[i]已经和它们组合过了，其中任何一个不变，那么都不可能再有组合满足
                    while (left < right && nums[left] == nums[left - 1]) left++; // 跳过重复
                    while (left < right && nums[right] == nums[right + 1]) right--; // 跳过重复
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {  // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }

}
