import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 用两个队列来实现栈的操作
 *
 * @author Sunss
 * @since 2021/3/25
 */
public class MyStack {

    private Queue<Integer> q1 = new LinkedBlockingQueue<>();
    private Queue<Integer> q2 = new LinkedBlockingQueue<>();
    private int flag = 1; // 用来标记当前是哪个队列添加元素

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (flag == 1) {
            q1.offer(x);
        } else {
            q2.offer(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (flag == 1) {
            if(q1.isEmpty()) return 0;
            int ele = 0;
            int size = q1.size();
            int count = 0;
            while (!q1.isEmpty()) {
                ele = q1.poll();
                if (++count < size) {
                    q2.offer(ele);
                }
            }
            flag = 2;
            return ele;
        } else {
            if(q2.isEmpty()) return 0;
            int ele = 0;
            int size = q2.size();
            int count = 0;
            while (!q2.isEmpty()) {
                ele = q2.poll();
                if (++count < size) {
                    q1.offer(ele);
                }
            }
            flag = 1;
            return ele;
        }
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (flag == 1) {
            if(q1.isEmpty()) return 0;
            int ele = 0;
            while (!q1.isEmpty()) {
                ele = q1.poll();
                q2.offer(ele);
            }
            flag = 2;
            return ele;
        } else {
            if(q2.isEmpty()) return 0;
            int ele = 0;
            while (!q2.isEmpty()) {
                ele = q2.poll();
                q1.offer(ele);
            }
            flag = 1;
            return ele;
        }
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return flag == 1 ? q1.isEmpty() : q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
