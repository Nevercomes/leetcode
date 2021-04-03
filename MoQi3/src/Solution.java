/**
 * 就统计层数？左子树的层数和右子树的层数？
 * <p>
 * 那时间为什么会给到 4s？
 * 从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次....
 * 65%的case WA 了
 *
 * @author Sunss
 * @since 2021/4/3
 */
public class Solution {
    /**
     * @param root TreeNode类 the root
     * @return int整型
     */

    static int level;


    public int maxDistance(TreeNode root) {
        // write code here
        // 先遍历子树
        if (root == null) return 0;
        int leftDepth = 0, rightDepth = 0;
        if (root.left != null) {
            level = 1;
            traverse(root.left, 1);
            leftDepth = level;
        }
        if (root.right != null) {
            level = 1;
            traverse(root.right, 1);
            rightDepth = level;
        }

        System.out.println(leftDepth + rightDepth + 1);
        return leftDepth + rightDepth + 1;
    }

    public void traverse(TreeNode node, int depth) {
        if (node.left != null) {
            traverse(node.left, depth + 1);
            level = Math.max(depth + 1, level);
        }
        if (node.right != null) {
            traverse(node.right, depth + 1);
            level = Math.max(depth + 1, level);
        }
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode right = new TreeNode();
//        root.right = right;
        Solution solution = new Solution();
        solution.maxDistance(root);
    }


}
