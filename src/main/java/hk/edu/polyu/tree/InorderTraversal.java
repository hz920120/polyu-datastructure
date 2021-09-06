package hk.edu.polyu.tree;

import hk.edu.polyu.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-06 13:40:50
 * @declaration 中序遍历
 * @e-mail hz920120@gmail.com
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();

        addLeft(root, stack);


        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);

            if (curr.right != null) {
                addLeft(curr.right, stack);
            }
        }
        return res;
    }

    private void addLeft(TreeNode nodes, Stack<TreeNode> stack) {
        TreeNode left = nodes;
        while (left != null) {
            stack.add(left);
            left = left.left;
        }
    }

    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        TreeNode treeNode = TreeNode.mkTree("[1,2,3,4,5,6,7]");
        inorderTraversal.inorderTraversal(treeNode);
        System.out.println(1);
    }
}
