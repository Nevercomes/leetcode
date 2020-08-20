import java.util.ArrayList;
import java.util.List;

/**
 * Z型变换
 * 解法：按照z型的规则遍历字符串，将字符在第几行保存起来即可
 * 注意点：可能字符长度不足所给定的numRows
 * @author Sunss
 * @since 2020/8/20
 */
class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            // 在首行和尾行的时候转向
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
