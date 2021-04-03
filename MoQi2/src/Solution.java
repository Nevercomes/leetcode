/**
 * 一个重复字符串由两个相同的字符串首尾拼接而成...
 *
 * 求最长重复子串
 * 60%的case 暴力果然是个及格分
 * @author Sunss
 * @since 2021/4/3
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a string字符串 待计算字符串
     * @return int整型
     */
    public int solve(String a) {
        // write code here
        // dp暂时想不出来，先来一个暴力试试水
        // 暴力的就是枚举长度，只要一个可行就可行，从高到低枚举
        int len = a.length() / 2;
        for (; len > 0; len--) {
            for (int i = 0; i + 2 * len <= a.length(); i++) {
                int j = i + len;
                if (a.substring(i, i + len).equals(a.substring(j, j + len))) {
                    return len * 2;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve("");
    }
}
