import java.util.Scanner;

/**
 * @author Sunss
 * @since 2021/3/27
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String seq = sc.nextLine();
            // 首先双指针判断回文
            boolean flag1 = false;
            boolean flag2 = false;
            int onlyI = -1, onlyJ = -1;
            for (int i = 0, j = n - 1; i <= j; i++, j--) {
                if (seq.charAt(i) != seq.charAt(j)) {
                    if (!flag1) {
                        flag1 = true;
                        onlyI = i;
                        onlyJ = j;
                    } else {
                        flag2 = true;
                        break;
                    }
                }
            }
            // 1 如果是偶数回文串那么无法修改，如果是奇数回文串则修改中间为0
            // 2 如果不是回文串则考虑修改为回文串
            if (flag2) { // 不是回文串，找到第一个不为0，修改为0
                for (int i = 0; i < n; i++) {
                    if (seq.charAt(i) != '0') {
                        System.out.println(seq.substring(0, i) + '0' + seq.substring(i + 1));
                        break;
                    }
                }
            } else if (flag1) {
                if (seq.charAt(onlyI) > seq.charAt(onlyJ)) {
                    System.out.println(seq.substring(0, onlyI) + seq.charAt(onlyJ) + seq.substring(onlyI + 1));
                } else {
                    System.out.println(seq.substring(0, onlyJ) + seq.charAt(onlyI) + seq.substring(onlyJ + 1));
                }
            } else {
                // 本身就是回文串
                if (seq.length() % 2 == 0) {
                    System.out.println(seq);
                } else {
                    System.out.println(seq.substring(0, seq.length() / 2) + '0' + seq.substring(seq.length() / 2 + 1));
                }
            }
        }
    }
}
