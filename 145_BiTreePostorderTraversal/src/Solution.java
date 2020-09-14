import java.util.LinkedList;
import java.util.List;

/**
 * @author Sunss
 * @since 2020/9/14
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class Solution {

    // 这是一种犯规做法，不是严格的后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }


}
