/**
 * @author Sunss
 * @since 2020/8/21
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}


public class Solution2 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        if(root.left == null && root.right == null) return 1;

        int minDep = Integer.MAX_VALUE;

        if (root.left != null) {
            minDep = Math.min(minDep, minDepth(root.left));
        }
        if (root.right != null) {
            minDep = Math.min(minDep, minDepth(root.right));
        }

        return minDep + 1;
    }
}
