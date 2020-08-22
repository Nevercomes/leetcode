import java.util.ArrayList;
import java.util.List;

/**
 * 题目：四个数，加减乘除算24点
 * 思路：美好的一天从遇见hard结束，又在复制粘贴开始
 * @author Sunss
 * @since 2020/8/22
 */
class Solution {
    static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<Double>();
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }

    public boolean solve(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    List<Double> list2 = new ArrayList<Double>();
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) { // 放入不被选择作为运算数字的两个数字，（不一定是两个，在递归思维的时候，习惯以第一遍进行来考虑，所以表达方便说了两个）
                            list2.add(list.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && i > j) { // i > j 进行交换律的优化（删除此句对结果也不会有什么影响）
                            continue;
                        }
                        if (k == ADD) {
                            list2.add(list.get(i) + list.get(j));
                        } else if (k == MULTIPLY) {
                            list2.add(list.get(i) * list.get(j));
                        } else if (k == SUBTRACT) {
                            list2.add(list.get(i) - list.get(j));
                        } else if (k == DIVIDE) { // 这里idea竟然说k总是为divide，idea也会犯这种低级错误？
                            if (Math.abs(list.get(j)) < EPSILON) {
                                continue;
                            } else {
                                list2.add(list.get(i) / list.get(j));
                            }
                        }
                        // 得到了新的数字，继续计算，直到只剩下一个数字，就是开头的退出条件了，这一套下来只是算了一种情况
                        if (solve(list2)) {
                            return true;
                        }
                        // 如果最后数字不是24，注意这一步只是在k里面的，也就是在选择运算符环节，最多尝试四种可能
                        // 弹出的永远是最新添加进去的那个由原酸得到的数字
                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}

