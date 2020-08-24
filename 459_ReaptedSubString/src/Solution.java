/**
 * 题目：判断字符串能否由它的字串构成
 * 思路一: 暴力匹配，三个优化条件，子串必然是前缀，子串不会大于一半，原串的长度必然为子串长度的倍数
 * @author Sunss
 * @since 2020/8/24
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}
