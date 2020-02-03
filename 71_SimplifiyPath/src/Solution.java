import java.util.Stack;

/**
 * 这道题存在非法字符串
 * Created by sun on 2020/2/1
 */
public class Solution {


    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < path.length(); i++) {
            String s = path.substring(i, i + 1);
            if (stack.isEmpty()) {
                stack.push(s);
            } else {
                String peek = stack.peek();
                // 其实这就是一个比较左右栈的问题 （左栈不是栈，可以按照顺序遍历字符串）编译器

                // 首先看左边，也就是s，s有三种情况，分别是 字母 . /
                if (s.equals("/")) {
                    // peek也是三种情况，分类比较
                    if (peek.equals("/")) {
                        // do noting
                    }
//                    else if (peek.equals(".")) {
//                        // 这里可以根据自己的逻辑来处理，相符合即可
//                        // 这里如果出现这种情况表示是当前目录
//                        stack.pop();
//                    }
                    else {
                        stack.push(s);
                    }
                } else if (s.equals(".")) {
                    // 出栈直到到达上一目录
                    if (peek.equals(".")) {
                        stack.pop(); // 弹出 "."
                        if (stack.size() > 1) {
                            stack.pop(); // 弹出 "/" 这里是必然会有/的，不然没有办法知道真正的目录
                        }
                        while (!stack.isEmpty()) {
                            String pop = stack.pop();
                            if (pop.equals("/")) {
                                stack.push(pop);
                                break;
                            }
                        }
                    } else {
                        stack.push(s);
                    }
                } else {
                    // 除去 / . 就是字母了，字母直接入栈
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
        if (res.length() == 2 && res.charAt(1) == '.') {
            res = "/";
        }
        if (res.length() > 1 && res.substring(res.length() - 1, res.length()).equals("/")) {
            res = res.substring(0, res.length() - 1);
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String test = "/..";
        solution.simplifyPath(test);
    }

}
