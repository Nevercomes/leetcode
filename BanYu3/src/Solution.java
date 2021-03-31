import java.util.Arrays;

/**
 * 求所有的排列，字典序
 * 怎么通过原排列得到下一个排列
 *
 * @author Sunss
 * @since 2021/3/30
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组
     * @return int整型二维数组
     */
    public int[][] exportAllOrders (int[] array) {
        // 先对原数组排序
        int[] arr = mergeSort(array);
        int len = arr.length;
        // 搞了半天还是没有学会怎么写全排列算法，还有半小时，看看能不能分析一下写出来
        // 总共有 len * (len-1) 种排列，下一种排列可以通过分析上一种排列直接O(1)得出
        // 确定是 O(1) 得出吗，怎么递推得到的？
        // 或者说使用DFS？

        return null;
    }

    public int[] mergeSort(int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        if(arr.length < 2) return arr;

        int middle = arr.length / 2;
        int[] leftArr = Arrays.copyOfRange(arr, 0, middle);
        int[] rightArr = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(mergeSort(leftArr), mergeSort(rightArr));
    }

    public int[] merge(int[] leftArr, int[] rightArr) {
        int[] res = new int[leftArr.length + rightArr.length];
        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr.length <= rightArr.length) {
                res[k++] = leftArr[i++];
            } else {
                res[k++] = rightArr[j++];
            }
        }
        while (i < leftArr.length) {
            res[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            res[k++] = rightArr[j++];
        }
        return res;
    }
}
