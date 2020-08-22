/**
 * @author Sunss
 * @since 2020/8/21
 */
public class Solution {
    public String intToRoman(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();
        int index = 0;
        while (index < 13) {
            if (num >= nums[index]) {
                res.append(romans[index]);
                // 作为加法因子，直接减去即可
                num -= nums[index];
            } else {
                index++;
            }
        }
        return res.toString();
    }
}
