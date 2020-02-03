import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sun on 2020/2/1
 */
public class Solution2 {

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < path.length(); i++) {
            String s = path.substring(i, i + 1);
            if (stack.isEmpty()) {
                stack.push(s);
            } else {
                String peek = stack.peek();
                if (s.equals("/")) {
                    if (peek.equals("/")) {
                        // do noting
                    } else if (peek.equals(".")) {
                        checkPoint(stack);
                    } else {
                        stack.push(s);
                    }
                } else {
                    stack.push(s);
                }
            }
        }
        checkPoint(stack);
        String[] arr = new String[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            arr[i++] = pop;
        }
        String res = "";
        for (int j = arr.length - 1; j >= 0; j--) {
            res += arr[j];
        }
        if (res.length() > 1 && res.charAt(res.length() - 1) == '/') {
            res = res.substring(0, res.length() - 1);
        }
        System.out.println(res);
        return res;
    }

    private void back(Stack<String> stack) {
        if (!stack.isEmpty()) {
            stack.pop();
        }
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            if (pop.equals("/")) {
                break;
            }
        }
        stack.push("/");
    }

    private void checkPoint(Stack<String> stack) {
        // 按照情况出栈，如果是非法串则再返回压栈
        // 把所有的点弹出，直到遇到 /
        if (stack.size() <= 1) {
            return;
        }
        if (!stack.peek().equals(".")) {
            return;
        }
        int k = 0;
        List<String> temp = new ArrayList<>();
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            if (pop.equals("/")) {
                break;
            }
            temp.add(pop);
            k++;
        }
        // 根据k来做判断
        switch (k) {
            case 0:
                break;
            case 1:
                stack.push("/");
                break;
            case 2:
                back(stack);
                break;
            default:
                stack.push("/");
                while (k > 0) {
                    k--;
                    stack.push(temp.get(k));
                }
                stack.push("/");
                break;
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String test = "/...";
        solution.simplifyPath(test);
    }

}
