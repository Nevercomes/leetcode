import java.util.Stack;

/**
 * Created by sun on 2020/2/1
 */
public class Solution3 {

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
                        // 按照情况出栈，如果是非法串则再返回压栈
                        // 把所有的点弹出，直到遇到 /
                        int k = 0;
                        while (!stack.isEmpty()) {
                            String pop = stack.pop();
                            if (pop.equals("/")) {
                                break;
                            }
                            k++;
                        }
                        // 根据k来做判断
                        switch (k) {
                            case 1:
                                stack.push("/");
                                break;
                            case 2:
                                while (!stack.isEmpty()) {
                                    String pop = stack.pop();
                                    if (pop.equals("/")) {
                                        break;
                                    }
                                }
                                stack.push("/");
                                break;
                            default:
                                stack.push("/");
                                while (k-- > 0) {
                                    stack.push(".");
                                }
                                stack.push("/");
                                break;
                        }
                    } else {
                        stack.push(s);
                    }
                } else {
                    stack.push(s);
                }
            }
        }
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
        if (res.length() > 1 && res.substring(res.length() - 1, res.length()).equals("/")) {
            res = res.substring(0, res.length() - 1);
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        String test = "/a//b////c/d//././/..";
        solution.simplifyPath(test);
    }

}
