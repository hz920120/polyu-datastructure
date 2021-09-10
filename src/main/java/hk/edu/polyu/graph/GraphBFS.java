package hk.edu.polyu.graph;

import hk.edu.polyu.graph.util.Graph;
import hk.edu.polyu.graph.util.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-10 10:22:08
 * @declaration 图的宽度优先遍历
 * @e-mail hz920120@gmail.com
 */
public class GraphBFS {

    public void bfs(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> reg = new HashSet<>();
        queue.add(node);
        reg.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.println(curr.val);
            for (Node next : curr.nexts) {
                if (!reg.contains(next)) {
                    queue.offer(next);
                }
            }
        }
    }
}
