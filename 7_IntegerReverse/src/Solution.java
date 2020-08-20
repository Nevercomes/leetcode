/**
 * 题目：反转给定整数，如果溢出则返回零
 * 思路：用数学方式来模拟堆栈的pop和push操作
 *
 * @author Sunss
 * @since 2020/8/20
 */
public class Solution {
    //pop operation:
//    pop = x % 10;
//    x /= 10;

    //push operation:
//    temp = rev * 10 + pop;
//    rev = temp;
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
