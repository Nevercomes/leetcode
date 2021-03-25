/**
 * 给两个数组，都是无重复元素的，数组1是数组2的子集
 * 求数组1中每个数在数组2中是否右侧有比它大的数
 * 暴力解法 时间复杂度 O(n * m)
 * 1 <= nums1.length <= nums2.length <= 1000
 *
 * @author Sunss
 * @since 2021/3/25
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            boolean theNumber = false;
            boolean noGreater = true;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    theNumber = true;
                }
                if (theNumber && nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    noGreater = false;
                    break;
                }
            }
            if (noGreater) res[i] = -1;
        }
        return res;
    }
}
