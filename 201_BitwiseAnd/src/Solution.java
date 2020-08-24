/**
 * 题目：给定范围 [m, n]，返回此范围内所有数字的按位与
 * 思路：分析过程我其实看不懂，但我知道肯定是找一个高位的公共前缀...
 * @author Sunss
 * @since 2020/8/23
 */
public class Solution {

    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }

    public static void main(String[] args) {
        int n = 0;
        System.out.println(n >> 1);
    }
}
