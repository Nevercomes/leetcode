import java.util.HashMap;
import java.util.Map;

/**
 * 给一个不存在重复元素的数组，求所有满足 a+b=c的 三元组
 * 输出个数
 *
 * @author Sunss
 * @since 2021/3/30
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param arr int整型一维数组
     * @return int整型
     */
    public int NumberOfTriplets (int[] arr) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], 1);
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (map.get(sum) != null) {
                    count++;
                }
            }
        }
        return count;
    }
    // 60%的case，估计超时了
}
