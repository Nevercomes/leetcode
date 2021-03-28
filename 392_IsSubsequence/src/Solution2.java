/**
 * 给两个字符串，判断前者是不是后者的字串
 * ace 是 abcde 的子串
 * 方法一，双指针，这和kmp不一样，kmp的匹配是不能delete元素的，而它可以，所以它不存在回溯问题
 * 时间复杂度为 O(n+m) 空间复杂度为 O(1)
 *
 * @author Sunss
 * @since 2021/3/28
 */
public class Solution2 {
    public boolean isSubsequence(String s, String t) {
        int next = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean flag = false;
            for (int j = next; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    next = j + 1;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
