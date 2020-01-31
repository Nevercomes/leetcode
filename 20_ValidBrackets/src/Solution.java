import java.util.List;
import java.util.Stack;

/**
 * Created by sun on 2020/1/31
 * <p>
 * 解题思路：一个简单的栈问题
 * 创建两个栈，先将所有的字符反向压入栈A
 * 之后栈A每次弹出一个字符到栈B，当栈A和栈B的括号匹配时则二者同时出栈
 * 当栈A为空时若栈B也为空则为有效字符串，反之则无效
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String ch = s.substring(i, i+1);
            stack1.push(ch);
        }
        while (!stack1.empty()) {
            String pop1 = stack1.pop();
            if (!stack2.empty()) {
                String peek2 = stack2.peek();
                if (isMatch(pop1, peek2)) {
                    stack2.pop();
                } else {
                    stack2.push(pop1);
                }
            } else {
                stack2.push(pop1);
            }
        }
        System.out.println(stack2.empty());
        return stack2.empty();
    }

    public boolean isMatch(String s1, String s2) {
        String s = s1 + s2;
        if (s.equals("()") || s.equals(")(")) {
            return true;
        } else if (s.equals("[]") || s.equals("][")) {
            return true;
        } else if (s.equals("{}") || s.equals("}{")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "";
        Solution solution = new Solution();
        solution.isValid(s);
    }

}
