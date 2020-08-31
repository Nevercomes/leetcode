import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 思路：bfs
 * @author Sunss
 * @since 2020/8/31
 */
public class Solution2 {

    boolean[] vis;
    int num;
    Queue<Integer> queue;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        queue = new LinkedList<>();
        vis[0] = true;
        queue.offer(0);
        while (!queue.isEmpty()) {
            num++;
            int x = queue.poll();
            for (int key : rooms.get(x)) {
                if (!vis[key]) {
                    vis[key] = true;
                    queue.offer(key);
                }
            }
        }
        return num == n;
    }
}
