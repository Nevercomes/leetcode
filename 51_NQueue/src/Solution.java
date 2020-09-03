import java.util.*;

/**
 * 题目：N皇后问题
 * 思路：首先要明确的是，这就是一个时间复杂为 O(N!)的问题，因为它有O(N!)种情况，要全部遍历到
 * 为了降低复杂度，方法就是将判断是否位置是否合法的复杂度降低到 O(1)， 可以使用集合和位运算
 * @author Sunss
 * @since 2020/9/3
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n]; // 表示queens[row] = column 等价于 queens[row][column] = 1
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>(); // 左上到右下，row index - column index = a
        Set<Integer> diagonals2 = new HashSet<Integer>(); // 左下到右上，row index + column index = b
        dfs(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    /**
     *
     * @param solutions 结果集合
     * @param queens 皇后放置
     * @param n 几皇后
     * @param row  当前第几行
     * @param columns 列约束
     * @param diagonals1  左上到右下斜线约束
     * @param diagonals2  左下到右上斜线约束
     */
    public void dfs(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) { // 已经放完 row == n-1是最后一行
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            // 外部dfs是row的下标，下面这个for循环是column的下标
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i; // 左上到右下，row index - column index = a
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i; // 左下到右上，row index + column index = b
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                dfs(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

}
