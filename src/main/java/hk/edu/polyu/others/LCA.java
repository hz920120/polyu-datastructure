package hk.edu.polyu.others;

import hk.edu.polyu.util.TreeNode;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-18 16:58:03
 * @declaration LCA
 * @e-mail hz920120@gmail.com
 */
public class LCA {


    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        if ((root.left == null && root.right == null) ||
                (root.left == null || root.right == null)) {
            return root.val;
        }

        return getLCA(root, o1, o2).val;
    }

    public TreeNode getLCA(TreeNode node, int o1, int o2) {

        if (node == null) {
            return null;
        }

        if (node.val == o1 || node.val == o2) {
            return node;
        }


        TreeNode getLeft = null;
        if (node.left != null) {
            getLeft = getLCA(node.left, o1, o2);
        }

        TreeNode getRight = null;
        if (node.right != null) {
            getRight = getLCA(node.right, o1, o2);
        }

        if (getLeft == null && getRight == null) {
            return null;
        } else if (getLeft != null && getRight != null) {
            return node;
        } else {
            return getLeft != null ? getLeft : getRight;
        }
    }
}
