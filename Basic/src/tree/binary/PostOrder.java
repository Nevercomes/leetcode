package tree.binary;

import tree.TreeNode;

import java.util.*;

/**
 * @author Sunss
 * @since 2020/9/15
 */
public class PostOrder {

    public void postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal_stack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode r = null; // r结点用来区分之前的结点是否被访问过
        while (root != null || !stack.isEmpty()) {
            if (root != null) { // 到树的最左面
                stack.push(root);
                root = root.left;
            } else {
                root = stack.peek(); // 看最左结点有没有右子树
                if (root.right != null && root.right != r) {
                    root = root.right;
                    stack.push(root);
                    root = root.left;     // 右子树再到最左
                } else {
                    root = stack.pop(); // 访问该结点，并标记被访问
                    res.add(root.val);
                    r = root;
                    root = null;
                }
            }
        }
        return res;
    }

}
