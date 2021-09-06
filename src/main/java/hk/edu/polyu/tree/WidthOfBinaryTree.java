package hk.edu.polyu.tree;

import hk.edu.polyu.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-06 14:50:25
 * @declaration 二叉树的宽度
 * @e-mail hz920120@gmail.com
 */
public class WidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {

        int res = 0;

        if (root == null) {
            return res;
        }

        res = Integer.MIN_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //TODO
        while (!queue.isEmpty()) {
            int len = queue.size();
            int left = -1;
            int right = -1;
            for (int i = 0; i < len; i++) {
                TreeNode curr = queue.poll();
                if (curr == null) {
                    continue;
                }
                queue.offer(curr.left == null ? null : curr.left);
                queue.offer(curr.right == null ? null : curr.right);

                if (left == -1) {
                    left = i;
                }

                right = i;
            }
            res = left == -1 ? res : Math.max(res, right - left + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        WidthOfBinaryTree widthOfBinaryTree = new WidthOfBinaryTree();
        TreeNode treeNode = TreeNode.mkTree("[1,3,2,5,null,null,9,6,null,null,7]");
        widthOfBinaryTree.widthOfBinaryTree(treeNode);
        System.out.println(1);
    }
}
