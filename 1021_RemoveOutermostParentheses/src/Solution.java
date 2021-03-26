import java.util.Stack;

/**
 * 给一个合法的括号串，要求分解成 A+B+C+...这样的形式
 * 分解之后去除每个part最外层的括号得到结果
 * 用栈来分part，每次栈空就是一个part，然后去掉每个part的最左和最右字符即可
 * 时间复杂度为 O(n),空间复杂度为O(n)
 *
 * @author Sunss
 * @since 2021/3/26
 */
public class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int start = 0, end = 0;
        if (S.length() > 0) stack.push(S.charAt(0));
        S = S + "(";
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == ')') {
                stack.pop();
            } else {
                if (stack.isEmpty()) {
                    end = i - 1;
                    // 截取字符串
                    if (end != start + 1) {
//                        System.out.println(start + " " + end);
//                        System.out.println(S.substring(start+1, end)); // 包括start，不包括end
                        res.append(S, start + 1, end);
                    }
                    start = i;
                }
                stack.push(S.charAt(i));
            }
        }
        return res.toString();
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.removeOuterParentheses("(()())(())");
//    }
}
