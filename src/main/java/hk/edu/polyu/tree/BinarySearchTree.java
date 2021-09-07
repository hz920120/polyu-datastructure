package hk.edu.polyu.tree;

import hk.edu.polyu.util.TreeNode;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-07 15:43:35
 * @declaration 二叉搜索树
 * @e-mail hz920120@gmail.com
 */
public class BinarySearchTree {

    //congrats! 一次性通过

    /*
    *
    * 条件：1.左子树也为BST
    *       2.右子树也为BST
    *       3.左树最大值小于当前节点，右树最大值大于当前节点
    *
    * */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root).isBST;
    }

    public ReturnType process(TreeNode root) {
        if (root == null) {
            return null;
        }

        ReturnType left = process(root.left);
        ReturnType right = process(root.right);
        boolean isBST = true;


        if (left == null && right == null) {
            return new ReturnType(true, root.val, root.val);
        }

        if ((left != null && !left.isBST) || (right != null && !right.isBST)) {
            isBST = false;
        }

        int min = root.val;
        int max = root.val;

        if (left != null) {
            if (left.max >= min) {
                isBST = false;
            }
            min = left.min;
         }

        if (right != null) {
            if (right.min <= max) {
                isBST = false;
            }
            max = right.max;
        }

        return new ReturnType(isBST, min, max);

    }

    public static class ReturnType {
        boolean isBST;
        int min;
        int max;

        public ReturnType (boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }

    }



}
