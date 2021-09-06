package hk.edu.polyu.tree;

import hk.edu.polyu.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-06 13:10:41
 * @declaration 先序遍历
 * @e-mail hz920120@gmail.com
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);

            //right
            if (curr.right != null) {
                stack.add(curr.right);
            }

            //left
            if (curr.left != null) {
                stack.add(curr.left);
            }

        }

        return res;
    }

    public static void main(String[] args) {
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        TreeNode treeNode = TreeNode.mkTree("[1,2,3,4,5,6,7]");
        preorderTraversal.preorderTraversal(treeNode);
        System.out.println(1);
    }

}
