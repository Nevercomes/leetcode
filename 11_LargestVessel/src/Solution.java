/**
 * @author Sunss
 * @since 2020/8/21
 */
public class Solution {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int v = (right - left) * Math.min(height[left], height[right]);
            ans = Math.max(ans, v);
            if (height[left] <= height[right]) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        }
        return ans;
    }

}
