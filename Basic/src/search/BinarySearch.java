package search;

/**
 * 二分虽然思路很简单，但是代码非常容易写错
 * 二分四类变形问题：
 * 1 查找第一个等于给定值的元素
 * 2 查找最后一个等于给定值的元素
 * 3 查找第一个大于等于给定值的元素
 * 4 查找最后一个小于等于给定值的元素
 *
 * @author Sunss
 * @since 2020/9/8
 */
public class BinarySearch {

    // 变形情况1
    public int bSearch1(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if(mid == 0 || a[mid - 1] != value) return mid;
                else high = mid - 1; // 继续二分
            }
        }
        return -1;
    }

    // 变形情况2
    public int bSearch2(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if(mid == a.length - 1 || a[mid + 1] != value) return mid;
                else low = mid + 1; // 继续二分
            }
        }
        return -1;
    }

    // 变形情况3
    public int bSearch3(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if(mid == 0 || a[mid - 1] < value) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // 变形情况4
    public int bSearch4(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if(mid == a.length - 1 || a[mid + 1] > value) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }
}
