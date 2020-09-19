import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目: 统计左叶子的数字之和
 * 思路：dfs ， bfs
 * @author Sunss
 * @since 2020/9/19
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int x) {
        this.val = x;
    }
}

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        // dfs
//        return root != null ? dfs(root) : 0;

        // bfs
        int res = 0;
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    res += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null) {
                if (!isLeafNode(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

    public int dfs(TreeNode root) {
        int res = 0;
        if (root.left != null) {
            res += isLeafNode(root.left) ? root.left.val : dfs(root.left);
        }
        if (root.right != null) {
            res += dfs(root.right);
        }
        return res;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }



}
