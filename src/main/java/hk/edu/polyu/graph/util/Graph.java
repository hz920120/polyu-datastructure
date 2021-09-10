package hk.edu.polyu.graph.util;

import com.sun.javafx.geom.Edge;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-10 09:57:09
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class Graph {

    HashMap<Integer, Node> nodes;

    HashSet<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }

}
