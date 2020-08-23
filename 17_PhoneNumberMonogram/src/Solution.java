import java.util.ArrayList;
import java.util.List;

/**
 * 题目：电话号码的字母组合
 * 思路：暴力搜索，列出所有可能结果
 * @author Sunss
 * @since 2020/8/23
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        permute(res, digits, new StringBuilder());
        return res;
    }
    private void permute(List<String> res, String digits, StringBuilder sb) {
        if (digits.length() == 0) {
            res.add(sb.toString());
            return;
        }
        for (char c : getChars(digits.charAt(0))) {
            sb.append(c);
            permute(res, digits.substring(1), sb); // 递归调用的转移关系，和charAt(0)统一起来了，表达的含义就是用过的数字从字符串剔除
            sb.deleteCharAt(sb.length() - 1); // 回溯主要体现在这部分，弹出当前数字映射所选取的字母，比如弹出a，那么下一个for就是压入b
        }
    }
    private char[] getChars(char c) {
        switch(c){
            case '2':
                return new char[]{'a', 'b', 'c'};
            case '3':
                return new char[]{'d', 'e', 'f'};
            case '4':
                return new char[]{'g', 'h', 'i'};
            case '5':
                return new char[]{'j', 'k', 'l'};
            case '6':
                return new char[]{'m', 'n', 'o'};
            case '7':
                return new char[]{'p', 'q', 'r', 's'};
            case '8':
                return new char[]{'t', 'u', 'v'};
            case '9':
                return new char[]{'w', 'x', 'y', 'z'};
            default:
                return new char[0];
        }
    }
}
