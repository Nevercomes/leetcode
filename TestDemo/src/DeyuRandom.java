import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 德育成绩打分
 * @author Sunss
 * @since 2020/9/15
 */
public class DeyuRandom {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(30);
        // 剩余的需要给出的分数
        for (int i = 2; i <= 18; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        for (Integer score : list) {
            System.out.println(score + " ");
        }
    }

}
