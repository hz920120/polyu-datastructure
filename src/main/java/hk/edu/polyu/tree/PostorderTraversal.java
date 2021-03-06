package hk.edu.polyu.tree;

import hk.edu.polyu.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-06 14:30:24
 * @declaration 后序遍历
 * @e-mail hz920120@gmail.com
 */
public class PostorderTraversal {
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//
//        Stack<TreeNode> stack = new Stack<>();
//        Stack<TreeNode> collectStack = new Stack<>();
//
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//            TreeNode treeNode = stack.pop();
//            collectStack.push(treeNode);
//
//            if (treeNode.left != null) {
//                stack.push(treeNode.left);
//            }
//
//            if (treeNode.right != null) {
//                stack.push(treeNode.right);
//            }
//        }
//
//        while (!collectStack.isEmpty()) {
//            res.add(collectStack.pop().val);
//        }
//
//        return res;
//    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        process(root, res);
        return res;
    }

    private void process(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) {
            return;
        }
        process(treeNode.left, res);
        process(treeNode.right, res);
        res.add(treeNode.val);
    }
}
