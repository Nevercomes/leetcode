import java.util.HashMap;
import java.util.Map;

/**
 * @author Sunss
 * @since 2020/8/22
 */
public class Solution {

    public int romanToInt(String s) {
        int sum = 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            {
                put('I',1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        }};

        int preNum = map.get(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = map.get(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

}
