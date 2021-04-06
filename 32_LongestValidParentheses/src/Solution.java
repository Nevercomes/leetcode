import java.util.Deque;
import java.util.LinkedList;

/**
 * 其实吧这个有效长度，就是最右端-最左端
 * 根据前面的分析，可以知道会有 ((()) 这种左括号留在栈里面的情况
 * 还有就是 无法匹配的 右括号 ())()()
 * 也会有 ()()() 这种栈空的情况，栈空和面对无法匹配的 右括号其实是同理的
 *
 * @author Sunss
 * @since 2021/4/6
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
