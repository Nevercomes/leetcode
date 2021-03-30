import java.util.Stack;

/**
 * @author Sunss
 * @since 2021/3/30
 */
public class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                char peek = stack.peek();
                if (Math.abs(peek - s.charAt(i)) == 32) { // 大小写字母之间的 ascii 码差了32
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
