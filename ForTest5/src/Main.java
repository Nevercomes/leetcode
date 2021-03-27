import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sunss
 * @since 2021/3/27
 */
public class Main {

    public static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        int leftSum = 0;
        List<Integer> resList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int rightSum = 0;
            for (int j = i + 1; j <= n; j++) {
                // 计算右半部分
                int tmp = j - 1;
                if (tmp % 2 == 0) {
                    rightSum -= nums[j];
                } else {
                    rightSum += nums[j];
                }
            }
//            System.out.println(rightSum);
            if (leftSum + rightSum == 0) {
                resList.add(i);
            }
            if (i % 2 == 0) {
                leftSum -= nums[i];
            } else {
                leftSum += nums[i];
            }
        }
        System.out.println(resList.size());
        for (int i = 0; i < resList.size(); i++) {
            if (i == resList.size() - 1) {
                System.out.print(resList.get(i));
            } else {
                System.out.print(resList.get(i) + " ");
            }
        }
    }
}
