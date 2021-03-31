/**
 * 山脉数组，找一个唯一的最大值？
 *
 * @author Sunss
 * @since 2021/3/30
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param arr int整型一维数组
     * @return bool布尔型
     */
    public boolean validMountainArray(int[] arr) {
        // write code here
        if (arr.length < 3) return false;
        int count = 0;
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
                count = 1;
            } else if (arr[i] == max) {
                count++;
            }
        }
        return count == 1 && index != 0 && index != arr.length - 1;
    }
}
