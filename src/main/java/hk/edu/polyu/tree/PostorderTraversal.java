package hk.edu.polyu.tree;

import hk.edu.polyu.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-06 14:30:24
 * @declaration postorderTraversal
 * @e-mail hz920120@gmail.com
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> collectStack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            collectStack.push(treeNode);

            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }

            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
        }

        while (!collectStack.isEmpty()) {
            res.add(collectStack.pop().val);
        }

        return res;
    }
}
