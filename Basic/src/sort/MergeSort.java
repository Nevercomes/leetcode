package sort;

import java.util.Arrays;

/**
 * @author Sunss
 * @since 2020/9/7
 */
public class MergeSort {

    public static int[] mergeSort(int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        if (arr.length < 2) return arr;

        int middle = arr.length / 2;
        int[] leftArr = Arrays.copyOfRange(arr, 0, middle);
        int[] rightArr = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(mergeSort(leftArr), mergeSort(rightArr));
    }

    public static int[] merge(int[] leftArr, int[] rightArr) {
        int[] res = new int[leftArr.length + rightArr.length];
        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
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

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 34, 3, 1411414, 1, 41};
        int[] arr1 = {1};
        int[] arr2 = {2, 1};
        int[] arr3 = {};
        printArr(mergeSort(arr));
        printArr(mergeSort(arr1));
        printArr(mergeSort(arr2));
        printArr(mergeSort(arr3));
    }

}
