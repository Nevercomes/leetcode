import java.util.Deque;
import java.util.LinkedList;

/**
 * 用栈的方法来做
 * DP感觉确实有点难理解
 *
 * 因为这个有效括号有一个特点就是它是分段的，每个有效段是分段的，必定是被一个多余的 ')' 分段
 * 还有一种情况比如说 '()(()', 只有当右括号匹配且栈为空的时候可以统计一次 temp
 *
 * 目前过不了 '(()()'
 * 说明这个方法是错的
 *
 * @author Sunss
 * @since 2021/4/6
 */
public class SolutionFake {

    public int longestValidParentheses(String s) {
        Deque<Character> stack = new LinkedList<>();
        // 左括号直接入栈
        // 遇到右括号的时候，如果栈顶是左括号，那么匹配，栈顶出栈，并记录长度
        int max = 0;
        int temp = 0;
        int whenEmpty = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                // 左括号则置空temp 可以过 '(()((()',但是就过不了 '(()()'
                temp = 0;
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') { // 这里很蠢，我栈里面肯定是 '(' 啊
                    temp += 2;
                    stack.pop();
                    max = Math.max(temp, max);
                    // 加这段可以过 '()(()'
                    if (stack.isEmpty()) {
                        whenEmpty += temp;
                        temp = 0;
                        max = Math.max(whenEmpty, max);
                    }
                } else {
                    temp = 0;
                    whenEmpty = 0;
                }
            }
        }

        return max;
    }

}
