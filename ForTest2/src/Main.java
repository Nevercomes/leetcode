import java.util.Scanner;

/**
 * @author Sunss
 * @since 2021/3/27
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long c1 = sc.nextLong();
        long c2 = sc.nextLong();
        long c = Math.min(c1, c2);
        int count = 0;
        long sum = 0L;
        sc.nextLine();
        String seq = sc.nextLine();
        for (int i = 0; i < n; i++) {
//            String res = sc.next();
            char res = seq.charAt(i);
            if (res == 'F') {
                count++;
                if (count == 3) {
                    count = 0;
                    sum += c;
                }
            } else {
                count = 0;
            }
        }
        System.out.println(sum);
    }
}
