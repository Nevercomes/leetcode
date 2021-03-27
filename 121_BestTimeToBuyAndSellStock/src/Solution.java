/**
 * 买卖股票，选择一天买入，再后续的某一天卖出，要求达到最大盈利
 * 好像和动态规划没关系啊，遍历的同时更新min，当前天与min取一个差值记录为max，更新min和max即可
 * 时间复杂度为 O(n), 空间复杂度为 O(1)
 *
 * @author Sunss
 * @since 2021/3/28
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int min = 100000;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
