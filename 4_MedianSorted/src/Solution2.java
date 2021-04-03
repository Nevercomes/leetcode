/**
 * @author: sun
 * @date: 2019/5/19
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 一个简单的插入排序
 */
class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] ans = new int[len];
        int idx1, idx2;
        idx1 = idx2 = 0;
        for (int i = 0; i < len; i++) {
            if (idx2 == len2) {
                ans[i] = nums1[idx1];
                idx1++;
                continue;
            } else if (idx1 == len1) {
                ans[i] = nums2[idx2];
                idx2++;
                continue;
            }
            if (nums1[idx1] <= nums2[idx2]) {
                ans[i] = nums1[idx1];
                idx1++;
            } else {
                ans[i] = nums2[idx2];
                idx2++;
            }
        }
        if (len % 2 == 0) {
            return (ans[len / 2] + ans[len / 2 - 1]) / 2.0;
        } else {
            return (ans[len / 2]);
        }
    }
}
