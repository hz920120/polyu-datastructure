package hk.edu.polyu.graph;

import hk.edu.polyu.graph.util.Node;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-10 10:42:54
 * @declaration 图的深度优先遍历
 * @e-mail hz920120@gmail.com
 */
public class GraphDfs {

    public void dfs(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        HashSet<Node> reg = new HashSet<>();
        stack.add(node);
        reg.add(node);
        System.out.println(node.val);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            for (Node next : curr.nexts) {
                //already registered
                if (!reg.contains(next)) {
                    stack.push(curr);
                    stack.push(next);
                    reg.add(next);
                    System.out.println(next.val);
                    break;
                }
            }
        }
    }
}
