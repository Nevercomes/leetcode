/**
 * @author: sun
 * @date: 2019/5/19
 */
class Solution {


    public String longestPalindrome(String s) {
        String ans = "";
        String cur = "";
        int len = s.length();
        int j = len - 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) == s.charAt(len - i - 1)) {

            }
        }
        if (cur.length() > ans.length()) {
            ans = cur;
        }
        return ans;
    }
}
