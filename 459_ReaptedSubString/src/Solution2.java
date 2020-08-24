import java.util.Arrays;

/**
 * 思路 KMP算法的解法，算法的学习放在另外时间
 * @author Sunss
 * @since 2020/8/24
 */
public class Solution2 {
    // 语言自带的字符串查找函数
    public boolean repeatedSubstringPattern(String s) {
//        return (s + s).indexOf(s, 1) != s.length();
        return kmp(s + s, s);
    }

    // 我们可以用KMP算法自己实现这个查找函数
    public boolean kmp(String query, String pattern) {
        int n = query.length();
        int m = pattern.length();
        int[] fail = new int[m];
        Arrays.fill(fail, -1);
        for (int i = 1; i < m; ++i) {
            int j = fail[i - 1];
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                j = fail[j];
            }
            if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        int match = -1;
        for (int i = 1; i < n - 1; ++i) {
            while (match != -1 && pattern.charAt(match + 1) != query.charAt(i)) {
                match = fail[match];
            }
            if (pattern.charAt(match + 1) == query.charAt(i)) {
                ++match;
                if (match == m - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
