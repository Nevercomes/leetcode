import java.util.Arrays;

/**
 * 题目，给出n和k，求1,2...n的第k个排列
 * 思路：是一道数学题，k′ =(k−1)mod(n−1)!+1 把问题转化为了规模减1的子问题
 * 即为求：[1,n]\a1这n-1个元素组成的排列中，第k'小的排列
 * @author Sunss
 * @since 2020/9/5
 */
public class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        k--;
        StringBuilder res = new StringBuilder();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; i++) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; j++) {
                order -= valid[j];
                if (order == 0) {
                    res.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return res.toString();
    }
}
