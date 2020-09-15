package tree.binary;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Sunss
 * @since 2020/9/15
 */
public class InOrder {

    // 递归的方式遍历 时间复杂度 o(n) 每个节点最多被访问两次
    public void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    // 栈的方式遍历
    public List<Integer> inOrderTraversal_stack(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) { // Null是不会入栈的
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

}
