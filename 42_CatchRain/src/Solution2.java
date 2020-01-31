/**
 * Created by sun on 2020/1/31
 */
public class Solution2 {

    public int trap(int[] height) {
        int res = 0;
        int idx1 = 0;
        int idx2 = -1;
        while (idx1 < height.length - 2) {
            // 寻找左边最高的柱子 (起始点)
            idx1 = findUpSeq(idx1, height);
            int max1 = height[idx1];
            System.out.println("idx1:" + idx1);
            if (idx1 >= height.length - 2) {
                break;
            }

            // 寻找右边最高的柱子
            boolean higher = false;
            int max2 = -1;
            int maxIdx = -1;
            for (int i = idx1 + 1; i < height.length; i++) {
                int h = height[i];
                if (h >= max1) {
                    idx2 = i;
                    higher = true;
                    break;
                }
                if (h >= max2) {
                    max2 = h;
                    maxIdx = i;
                }
            }
            if (higher) {
                res += cal(idx1, idx2, height);
                idx1 = idx2;
            } else {
                res += cal(idx1, maxIdx, height);
                idx1 = maxIdx;
            }
        }
        System.out.println(res);
        return res;
    }

    /**
     * 寻找连续上升字串
     *
     * @param begin
     * @param height
     * @return 坐标
     */
    private int findUpSeq(int begin, int[] height) {
        int idx = begin;
        for (int i = begin; i < height.length - 1; i++) {
            if (height[i + 1] >= height[i]) {
                idx = i + 1;
            } else {
                idx = i;
                break;
            }
        }
        return idx;
    }

    private int cal(int idx1, int idx2, int[] height) {
        int min = Math.min(height[idx1], height[idx2]);
        int res = 0;
        for (int i = idx1 + 1; i < idx2; i++) {
            if (height[i] < min) {
                res += min - height[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] h2 = {5, 2, 1, 2, 1, 5};
        int[] h3 = {0, 1, 0, 2, 1, 0, 1};
        int[] h4 = {1, 7, 6, 7};
        solution.trap(h2);
    }

}
