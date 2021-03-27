import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Sunss
 * @since 2021/3/27
 */
public class Main {

    Map<Integer, Integer> firstMap = new HashMap<>();
    Map<Integer, Integer> lastMap = new HashMap<>();

    public static void main(String[] args) {

        Main obj = new Main();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            if (obj.firstMap.get(num) == null) {
                obj.firstMap.put(num, i);
            } else {
                obj.lastMap.put(num, i);
            }
        }
        sc.nextLine();
        while (m-- > 0) {
            int num = sc.nextInt();
            sc.nextLine();
            if (obj.firstMap.get(num) == null) {
                System.out.println(0);
            } else {
                Integer index1 = obj.firstMap.get(num);
                Integer index2 = obj.lastMap.get(num);
                if (index2 == null) {
                    System.out.println(index1 + " " + index1);
                } else {
                    System.out.println(index1 + " " + index2);
                }
            }
        }
    }
}
