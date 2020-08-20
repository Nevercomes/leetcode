import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：字符串转整数
 * 思路：有限状态自动机
 * 注意：
 *
 * @author Sunss
 * @since 2020/8/20
 */
public class Solution {
    int myAtoi(String str) {
        Automaton automaton = new Automaton();
        for (char c : str.toCharArray())
            automaton.get(c);
        System.out.println(automaton.sign * (int) automaton.ans);
        return automaton.sign * (int) automaton.ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.myAtoi("-91283472332");
    }

}

class Automaton {
    String state = "start";
    static Map<String, List<String>> map = new HashMap<>();

    static {
        map.put("start", Arrays.asList("start", "signed", "in_number", "end"));
        map.put("signed", Arrays.asList("end", "end", "in_number", "end"));
        map.put("in_number", Arrays.asList("end", "end", "in_number", "end"));
        map.put("end", Arrays.asList("end", "end", "end", "end"));
    }

    public int sign = 1;
    public long ans = 0;

    public int getCol(char c) {
        if (Character.isSpaceChar(c)) return 0;
        if (c == '+' || c == '-') return 1;
        if (Character.isDigit(c)) return 2;
        return 3;
    }

    public void get(char c) {
        state = map.get(state).get(getCol(c));
        if (state.equals("in_number")) {
            ans = ans * 10 + (c - '0');
            ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, (long)Integer.MAX_VALUE + 1);
        } else if (state.equals("signed")) {
            sign = c == '+' ? 1 : -1;
        }
    }
}
