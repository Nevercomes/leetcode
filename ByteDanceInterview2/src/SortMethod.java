import java.util.Arrays;

/**
 * @author Sunss
 * @since 2021/4/8
 */
public class SortMethod {

//    public void sort(int[] nums) {
//        int[] res = mergeSort(nums, 0, nums.length);
//    }
//
//    public int[] mergeSort(int[] nums, int left, int right) {
//        if (left <= right - 1) {
//
//        }
//        int mid = (left + right) / 2;
//        int[] leftArr = Arrays.copyOfRange(nums, left, mid);
//        int[] rightArr = Arrays.copyOfRange(nums, mid, right);
//        merge(mergeSort(nums, left, mid), mergeSort(nums, mid + 1, right));
//    }
//
//    public int[] merge(int[] nums1, int[] nums2) {
//        int[] res = new int[nums1.length + nums2.length];
//
//        int i = 0, j = 0, k = 0;
//        while (i < nums1.length && j < nums2.length) {
//            if (nums1[i] <= nums2[j]) {
//                res[k++] = nums1[i++];
//            } else {
//                res[k++] = nums2[j++];
//            }
//        }
//        while (i < nums1.length) {
//            res[k++] = nums1[i++];
//        }
//        while (j < nums2.length) {
//            res[k++] = nums2[j++];
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//
//    }
}
