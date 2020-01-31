/**
 * @author: sun
 * @date: 2019/5/18
 */
class Solution {

    private String cur; // 当前最长无重复子串
    private int l = 0; // 对应在原串中的左index
    private int r = 1; // 对应在右串中的右index
    private int max = 0;

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if(s.length() == 1) {
            return 1;
        }
        cur = s.substring(l, r);
        for (int i = 1; i < s.length(); i++) {
            String ch = s.charAt(i) + "";
            if (cur.contains(ch)) {
                int idx = getIndex(cur, ch.charAt(0));
                l = l + idx + 1;
                r = r + 1;
                if (l < s.length() && r <= s.length() && l < r) {
                    cur = s.substring(l, r);
                }
            } else {
                r = r + 1;
                if (r <= s.length()) {
                    cur = s.substring(l, r);
                }
            }
            if (cur.length() > max) {
                max = cur.length();
            }
        }
        return max;
    }

    private int getIndex(String s, char ch) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                return i;
            }
        }
        return 0;
    }
}
