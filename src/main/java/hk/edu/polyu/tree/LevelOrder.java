package hk.edu.polyu.tree;

import hk.edu.polyu.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-06 14:51:54
 * @declaration 二叉树的层序遍历
 * @e-mail hz920120@gmail.com
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> currIntegers = new ArrayList<>();

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode curr = queue.poll();
                currIntegers.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            res.add(currIntegers);
            currIntegers = new ArrayList<>();
        }

        return res;
    }

    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        TreeNode treeNode = TreeNode.mkTree("[1,2,3,4,5,6,7]");
        levelOrder.levelOrder(treeNode);
        System.out.println(1);
    }
}
