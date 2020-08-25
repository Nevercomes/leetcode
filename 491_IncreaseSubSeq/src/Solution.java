import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 题目：枚举所有递增子序列
 * 思路：dfs，剪枝
 * 其它：考虑存储的消耗、判重的消耗
 *
 * @author Sunss
 * @since 2020/8/25
 */
public class Solution {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> temp = new ArrayList<Integer>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (nums[cur] >= last) { // 剪枝条件，大于等于保证有效
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != last) { // 剪枝条件，不相等则跳过当前
            dfs(cur + 1, last, nums);
        }
    }


}
