import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：输入一个数字n，生成所有可能的有效括号的对数
 * 思路：暴力法，列出所有括号组合，判断是否为有效
 * 复杂度，总共有 2^2n 种可能，判断没有是否有效的复杂度为 n 总的复杂度为 O(n2^2n)
 * @author Sunss
 * @since 2020/8/24
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    // 过程很简单，递归地生成，每个位置先枚举左括号，然后枚举右括号
    public void generateAll(char[] current, int pos,  List<String> res) {
        if (pos == current.length) {
            if (valid(current)) {
                res.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, res);
            current[pos] = ')';
            generateAll(current, pos+1, res);
        }
    }

    // 判断一个括号串有效性的一个简单通式：左右数量是否不匹配，右括号是否提前出现了
    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
}
