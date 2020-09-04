import java.util.ArrayList;
import java.util.List;

/**
 * 题目：给定一个二叉树，返回所有从根节点到叶子节点的路径
 * 思路：二叉树遍历 bfs and dfs
 * @author Sunss
 * @since 2020/9/4
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        dfs(root, "", paths);
        return paths;
    }

    public void dfs(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuilder pathSB = new StringBuilder(path);
            pathSB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                dfs(root.left, pathSB.toString(), paths);
                dfs(root.right, pathSB.toString(), paths);
            }
        }
    }
}
