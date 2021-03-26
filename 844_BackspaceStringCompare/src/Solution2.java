/**
 * 比较两个字符串，#相当于退格符
 * 可以用栈重构字符串
 * 时间复杂度 O(n+m),空间复杂度O(n+m)
 *
 * @author Sunss
 * @since 2021/3/26
 */
public class Solution2 {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String str) {
        StringBuffer ret = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            char ch = str.charAt(i);
            if (ch != '#') {
                ret.append(ch);
            } else {
                if (ret.length() > 0) {
                    ret.deleteCharAt(ret.length() - 1);
                }
            }
        }
        return ret.toString();
    }
}
