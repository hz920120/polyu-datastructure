package hk.edu.polyu.tree;

import hk.edu.polyu.util.TreeNode;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-07 21:37:15
 * @declaration 二叉树的最近公共祖先
 * @e-mail hz920120@gmail.com
 */
public class LowestCommonAncestor {

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//
//        //using hashmap and set
//
//        //using hashmap to store the father of every node
//        HashMap<TreeNode, TreeNode> map = new HashMap<>();
//        map.put(root, root);
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int len = queue.size();
//            for (int i = 0; i < len; i++) {
//                TreeNode curr = queue.poll();
//                if (curr.left != null) {
//                    map.put(curr.left, curr);
//                    queue.offer(curr.left);
//                }
//                if (curr.right != null) {
//                    map.put(curr.right, curr);
//                    queue.offer(curr.right);
//                }
//            }
//        }
//
//        HashSet<TreeNode> fathers = new HashSet<>();
//        fathers.add(p);
//        while (p != map.get(p)) {
//            fathers.add(map.get(p));
//            p = map.get(p);
//        }
//
//        while (q != map.get(q)) {
//            if (fathers.contains(q)) {
//                return q;
//            }
//            q = map.get(q);
//        }
//        return root;
//    }

    //TODO
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || p == null || q == null) {
            return null;
        }

        TreeNode l = findPorQ(root.left,p);
        TreeNode r = findPorQ(root.right,q);

        if (l == null & r == null) {
            return root;
        }else {
            return (l != null && r != null) ? root : (l == null) ? r : l;
        }
//        return l;

    }

    public TreeNode findPorQ(TreeNode root, TreeNode x) {
        if (root == null || x == root) {
            return root;
        }

        TreeNode left = findPorQ(root.left, x);
        TreeNode right = findPorQ(root.right, x);

        if (left == null && right == null) {
            return null;
        } else {
            return root;
        }
    }


    public static void main(String[] args) {

//        TreeNode root = TreeNode.mkTree("[37,-34,-48,null,-100,-101,48,null,null,null,null,null,null," +
//                "-54,null,null,null,null,null,null,null,null,null,null,null,null,null," +
//                "-71,-22,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null," +
//                "8,null,null,null,null,]");
        TreeNode root = TreeNode.mkTree("[1,2]");
        TreeNode q = root;
        TreeNode p = root.left;
        TreeNode.printTree(root);

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode re = lowestCommonAncestor.lowestCommonAncestor(root , p, q);
        System.out.println(1);
    }

}
