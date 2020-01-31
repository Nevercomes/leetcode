import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * wrong solution
 * 接雨水问题
 * 虽然一个栈（不用栈）也可以操作，但是我喜欢两个栈，看起来简洁且逻辑清晰
 * Created by sun on 2020/1/31
 */
public class Solution {

    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        List<Integer> tempHeight = new ArrayList<>();
        for (int i = height.length - 1; i >= 0; i--) {
            stack1.push(height[i]);
        }
        while (!stack1.empty()) {
            int pop = stack1.peek();
            if (pop == 0) {
                stack1.pop();
            } else {
                break;
            }
        }
        while (!stack1.empty()) {
            tempHeight.clear();
            int pop1 = stack1.pop();
            if (!stack2.empty()) {
                int peek2 = stack2.peek();
                // 比较左栈和右栈的大小，如果左 <= 右则直接入栈
                // 如果左 > 右则右向下寻找最大值，左向下寻找大于右且连续最大值的点
                // 之后这个高度去减去两峰之间的柱子就是乘雨水的量
                if (pop1 <= peek2) {
                    stack2.push(pop1);
                } else {
                    // 找到右栈最大值
                    int pop2 = stack2.pop();
                    int max2 = pop2;
                    tempHeight.add(pop2);
                    while (!stack2.empty()) {
                        int temp2 = stack2.peek();
                        if (temp2 >= pop2) {
                            tempHeight.add(temp2);
                            pop2 = temp2;
                            max2 = temp2;
                            stack2.pop();
                        } else {
                            break;
                        }
                    }
                    // 遍历左栈
                    // 左栈的寻找比较特殊，需要寻找的是一个连续最大值，这里是特殊的，如果这个最大值还是比5小则可以继续往下找

                    int max1 = pop1;
                    tempHeight.add(pop1);
                    boolean flag = false;
                    while (!stack1.empty()) {
                        int temp1 = stack1.peek();
                        if (temp1 >= pop1 && temp1 >= max2) {
                            flag = true;
                        }
                        if (temp1 >= pop1 || (temp1 <= max2 && !flag)) {
                            tempHeight.add(temp1);
                            pop1 = temp1;
                            max1 = temp1;
                            stack1.pop();
                        } else {
                            break;
                        }
                    }
                    res += cal(tempHeight, max1, max2);
                    stack2.push(max1);
                }
            } else {
                stack2.push(pop1);
            }
        }
        System.out.println("res:" + res);
        return res;
    }

    private int cal(List<Integer> list, int max1, int max2) {
        int res = 0;
        int min = Math.min(max1, max2);
        System.out.println("max1:" + max1);
        System.out.println("max2:" + max2);
        for (int h : list) {
            System.out.println(h);
            if (h < min) {
                res += min - h;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] h2 = {5, 2, 1, 2, 1, 5, 6, 7, 4, 5, 1};
        int[] h3 = {0, 1, 0, 2, 1, 0, 1, 3};
        solution.trap(h3);
    }

}
