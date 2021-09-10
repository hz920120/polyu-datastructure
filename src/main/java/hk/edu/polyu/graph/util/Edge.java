package hk.edu.polyu.graph.util;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-10 10:07:57
 * @declaration graph里的边
 * @e-mail hz920120@gmail.com
 */
public class Edge {

    public int w;

    public Node from;

    public Node to;

    public Edge(int w, Node from, Node to) {
        this.w = w;
        this.from = from;
        this.to = to;
    }

}
