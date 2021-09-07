package hk.edu.polyu.tree;

import hk.edu.polyu.util.TreeNode;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-07 16:30:59
 * @declaration 平衡二叉树
 * @e-mail hz920120@gmail.com
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return process(root).isBBT;
    }

    public ReturnType process(TreeNode node) {
        if (node == null) {
            return new ReturnType(true, 0);
        }

        /*
        * 条件：1.左子树平衡
        *       2.右子树平衡
        *       3.左子树高度和右子树高度差值  < 2
        * */

        ReturnType left = process(node.left);
        ReturnType right = process(node.right);
        boolean isBBT = true;

        if (!left.isBBT || !right.isBBT) {
            isBBT = false;
        }

        if (Math.abs(left.height - right.height) > 1) {
            isBBT = false;
        }

        return new ReturnType(isBBT, Math.max(left.height, right.height) + 1);
    }

    public static class ReturnType {
        boolean isBBT;
        int height;

        public ReturnType(boolean isBBT, int h) {
            this.isBBT = isBBT;
            this.height = h;
        }

    }
}
