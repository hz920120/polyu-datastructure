package hk.edu.polyu.tree;

import hk.edu.polyu.util.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-07 21:37:15
 * @declaration 二叉树的最近公共祖先
 * @e-mail hz920120@gmail.com
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //using hashmap and set

        //using hashmap to store the father of every node
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    map.put(curr.left, curr);
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    map.put(curr.right, curr);
                    queue.offer(curr.right);
                }
            }
        }

        HashSet<TreeNode> fathers = new HashSet<>();
        fathers.add(p);
        while (p != map.get(p)) {
            fathers.add(map.get(p));
            p = map.get(p);
        }

        while (q != map.get(q)) {
            if (fathers.contains(q)) {
                return q;
            }
            q = map.get(q);
        }
        return root;
    }


    public static void main(String[] args) {

        TreeNode root = TreeNode.mkTree("[37,-34,-48,null,-100,-101,48,null,null,null,null,null,null," +
                "-54,null,null,null,null,null,null,null,null,null,null,null,null,null," +
                "-71,-22,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null," +
                "8,null,null,null,null,]");
        TreeNode p = root.right.left;
        TreeNode q = root.right.right.left.left;
        TreeNode.printTree(root);

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        lowestCommonAncestor.lowestCommonAncestor(root , p, q);
    }

}
