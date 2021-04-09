import java.util.Scanner;

/**
 * @author Sunss
 * @since 2021/4/9
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                nums[n - 1 - i][n - 1 - j] = num;
            }
            sc.nextLine();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(nums[i][j]);
                if (j != n - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }

    }
}
