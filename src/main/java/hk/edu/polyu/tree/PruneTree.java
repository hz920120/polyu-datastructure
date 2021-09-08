package hk.edu.polyu.tree;

import hk.edu.polyu.util.TreeNode;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-08 13:10:08
 * @declaration 二叉树的剪枝
 * @e-mail hz920120@gmail.com
 */
public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

//        if (root.val == 0) {
//            if (root.left != null && root.left.val == 0 && root.right != null && root.right.val == 0) {
//                return null;
//            }
//        }

        ReturnType returnType = process(root);
        if (returnType.canBePruned) {
            return null;
        }
        return root;
    }

    private ReturnType process(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }

        ReturnType left = process(treeNode.left);
        ReturnType right = process(treeNode.right);
        boolean canBePruned = false;


        if (left == null && right == null) {
            canBePruned = treeNode.val == 0;
        } else if (left != null && right != null) {
            canBePruned = left.canBePruned && right.canBePruned && treeNode.val == 0;
            treeNode.left = left.canBePruned ? null : treeNode.left;
            treeNode.right = right.canBePruned ? null : treeNode.right;
        } else {
            if (left != null && left.canBePruned) treeNode.left = null;
            if (right != null && right.canBePruned) treeNode.right = null;
            canBePruned = treeNode.val == 0 && (left != null ? left.canBePruned : right.canBePruned);
        }

//        if (left == null && right == null && treeNode.val == 0) {
//            canBePruned = true;
//        }
//        if (left!= null && left.canBePruned) {
//            treeNode.left = null;
//        }
//
//        if (right != null && right.canBePruned) {
//            treeNode.right = null;
//        }
//
//        if (left != null && left.canBePruned && right != null && right.canBePruned) {
//            if (treeNode.val == 0) {
//                canBePruned = true;
//            }
//        }
//
//        if (left != null || right != null) {
//            canBePruned = treeNode.left == null ? right.canBePruned : left.canBePruned;
//        }
//        if (left.canBePruned && right.canBePruned) {
//            if (treeNode.left == null && treeNode.right == null) {
//                treeNode = null;
//                canBePruned = true;
//            } else if (treeNode.left != null && treeNode.right != null) {
//                if (treeNode.left.val == 0 && treeNode.right.val == 0) {
//                    treeNode = null;
//                    canBePruned = true;
//                }
//            } else {
//                if (treeNode.left == null) {
//                    canBePruned = treeNode.right.val == 0;
//                    treeNode = canBePruned ? null : treeNode;
//                }
//                if (treeNode.right == null) {
//                    canBePruned = treeNode.left.val == 0;
//                    treeNode = canBePruned ? null : treeNode;
//                }
//            }
//        }
        return new ReturnType(canBePruned);
    }

    public static class ReturnType {
        boolean canBePruned;

        public ReturnType(boolean canBePruned) {
            this.canBePruned = canBePruned;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.mkTree("[1,1,0,1,1,0,1,0]");
        TreeNode.printTree(treeNode);
        PruneTree pruneTree = new PruneTree();
        TreeNode res = pruneTree.pruneTree(treeNode);
        System.out.println(1);
    }

}
