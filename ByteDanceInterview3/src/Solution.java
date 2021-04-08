/**
 * 给一个int型整数数组 和一个 等长度的数组b
 * 要求 初始化 数组b bi = 数组a的所有元素乘积 / ai
 * 过程中不能使用除法，要求时间复杂度 为 O(n)
 * <p>
 * 很直白地可以想到 就是不乘 ai 就可以了，这样子的话时间复杂度为 O(n^2)
 * 要想达到 时间复杂度为 O(n), 可以使用两遍前缀和优化
 *
 * @author Sunss
 * @since 2021/4/8
 */
public class Solution {
    public int[] initArray(int[] nums) {
        int[] b = new int[nums.length];
        int[] c = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                b[i] = nums[i];
            } else {
                b[i] = b[i - 1] * nums[i];
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                c[i] = nums[i];
            } else {
                c[i] = c[i + 1] * nums[i];
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1 && i - 1 >= 0) b[i] = b[i - 1];
            else if (i == 0 && i + 1 < nums.length) b[i] = c[i + 1];
            else b[i] = b[i - 1] * c[i + 2];
        }

        return b;
    }
}
