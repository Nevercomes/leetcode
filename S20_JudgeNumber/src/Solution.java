import java.util.HashMap;
import java.util.Map;

/**
 * 题目：给定一个字符串，判断是否属于数字
 * 思路：自动机
 * @author Sunss
 * @since 2020/9/2
 */
public class Solution {
    enum State {
        STATE_START, // 起始空格
        STATE_INT_SIGN, // 符号位
        STATE_INTEGER, // 整数部分
        STATE_POINT, // 左侧有整数的小数点
        STATE_POINT_WITHOUT_INT, // 左侧无整数的小数点
        STATE_FRACTION, // 小数部分
        STATE_EXP, // 字符e
        STATE_EXP_SIGN, // 指数部分的符号位
        STATE_EXP_NUMBER, // 指数部分的整数部分
        STATE_END // 末尾的空格
    }

    enum CharType {
        CHAR_NUMBER, // 数字
        CHAR_EXP, // 字符e
        CHAR_POINT, // 小数点
        CHAR_SIGN, // 符号 +/-
        CHAR_SPACE, // 空格
        CHAR_ILLEGAL, // 非法
    }

    public boolean isNumber(String s) {

        // 转移规则适用map保存为一张二维表
        Map<State, Map<CharType, State>> transfer = new HashMap<>();
        // 之后就是保存五种字符的转移状态
        // 保存对应的转移状态 - 起始
        Map<CharType, State> startMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_START);
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        }};
        transfer.put(State.STATE_START, startMap);

        // 保存对应的转移状态 - 整数符号
        Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        }};
        transfer.put(State.STATE_INT_SIGN, intSignMap);

        // 保存对应的转移状态 - 整数
        Map<CharType, State> integerMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_POINT, State.STATE_POINT);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_INTEGER, integerMap);

        // 保存对应的转移状态 - 小数点
        Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_POINT, pointMap);

        // 保存对应的转移状态 - 无整数位的小数点
        Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        }};
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);

        // 保存对应的转移状态 - 小数部分
        Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_FRACTION, fractionMap);

        // 符号e
        Map<CharType, State> expMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        }};
        transfer.put(State.STATE_EXP, expMap);

        // 指数符号
        Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_SIGN, expSignMap);

        // 指数数字
        Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);

        // 结束
        Map<CharType, State> endMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_END, endMap);

        int length = s.length();
        State state = State.STATE_START;
        for (int i = 0; i < s.length(); i++) {
            CharType charType = toCharType(s.charAt(i));
            if (transfer.get(state).containsKey(charType)) {
                state = transfer.get(state).get(charType);
            } else {
                return false;
            }
        }
        return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
    }

    public CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else if (ch == ' ') {
            return CharType.CHAR_SPACE;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }

}
