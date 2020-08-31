import java.util.List;

/**
 * 题目：给定一个房间数组，每个房间里面又有一个钥匙数组，问能不能打开所有房间
 * 思路：深搜或者广搜，深搜就是不断进入房间，广度就是先进入完一个钥匙数组的房间
 * @author Sunss
 * @since 2020/8/31
 */
public class Solution {
    boolean[] vis;
    int num;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    public void dfs(List<List<Integer>> rooms, int x) {
        vis[x] = true;
        num++;
        for (int key : rooms.get(x)) {
            if (!vis[key]) {
                dfs(rooms, key);
            }
        }
    }
}
