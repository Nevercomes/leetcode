import java.util.Scanner;

/**
 * @author Sunss
 * @since 2021/3/27
 */
public class Main {
    public static void main(String[] args) {

        Main obj = new Main();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        // 暴力解法 时间复杂度 n * k^2
        int biggest = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < k; j++) {
                int tmp = obj.cal(nums, i, j);
                if (tmp > biggest) {
                    biggest = tmp;
                }
            }
        }
        System.out.println(biggest);
    }

    public int cal(int[] nums, int l, int r) {
        int tmp = 0;
        for (int i = l; i <= r; i++) {
            tmp ^= nums[i];
        }
        return tmp;
    }
}
