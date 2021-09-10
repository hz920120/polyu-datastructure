package hk.edu.polyu.graph.util;

import java.util.ArrayList;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-10 10:07:18
 * @declaration graph里的节点
 * @e-mail hz920120@gmail.com
 */
public class Node {

    int val;

    int in;

    int out;

    ArrayList<Node> nexts;

    ArrayList<Edge> edges;

    public Node(int val) {
        this.val = val;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
