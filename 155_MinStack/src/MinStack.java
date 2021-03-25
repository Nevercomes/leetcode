import java.util.ArrayList;
import java.util.List;

/**
 * @author Sunss
 * @since 2021/3/25
 */
public class MinStack {

    /**
     * initialize your data structure here.
     */

    private List<Integer> list;
    private int len;
    private int index;

    public MinStack() {
        list = new ArrayList<>();
        len = 0;
        index = -1;
    }

    public void push(int val) {
        list.add(val);
        index++;
        len++;
    }

    public void pop() {
        if (len > 0) {
            list.remove(index);
            index--;
            len--;
        }
    }

    public int top() {
        if (len == 0) {
            return 0;
        }
        return list.get(index);
    }

    public int getMin() {
        if (len == 0) {
            return 0;
        }
        int tmp = index;
        int min = Integer.MAX_VALUE;
        while (tmp >= 0) {
            if (list.get(tmp) < min) {
                min = list.get(tmp);
            }
            tmp--;
        }
        return min;
    }
}
