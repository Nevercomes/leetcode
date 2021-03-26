/**
 * 双指针从后往前遍历
 *
 * @author Sunss
 * @since 2021/3/26
 */
public class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    i--;
                    skipS--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    j--;
                    skipT--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) { // 判断当前字符是否相等
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) { // 如果其中一个超出了，一个还没超出则肯定不等
                    return false;
                }
            }
            i--;
            j--;
        }

        return true;
    }
}
