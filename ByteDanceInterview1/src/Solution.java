import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Sunss
 * @since 2021/4/8
 */
public class Solution {

    public String forMax(int[] nums) {
        List<Foo> list = new ArrayList<>(nums.length);
        boolean allZero = true;
        for (int i = 0; i < nums.length; i++) {
            list.add(new Foo(String.valueOf(nums[i])));
            if (nums[i] != 0) {
                allZero = false;
            }
        }
        if (allZero) {
            return "0";
        }
        list.sort(new Comparator<Foo>() {
            @Override
            public int compare(Foo o1, Foo o2) {
                String s1 = o1.val;
                String s2 = o2.val;
                int i = 0, j = 0;
                for (; i < s1.length() && j < s2.length(); i++, j++) {
                    if (s1.charAt(i) > s2.charAt(i)) {
                        return -1;
                    } else if (s1.charAt(i) < s2.charAt(j)) {
                        return 1;
                    }
                }
                if (i == s1.length()) {
                    return -1;
                }
                if (j == s2.length()) {
                    return 1;
                }
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Foo foo : list) {
            sb.append(foo.val);
        }
        return sb.toString();
    }

    class Foo {
        String val;

        public Foo(String val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }
}
