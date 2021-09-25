package hk.edu.polyu.disjointset;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-25 12:49:28
 * @declaration 元素集合
 * @e-mail hz920120@gmail.com
 */
public class Element<V> {

    V value;

    V father;

    public Element(V value) {
        this.value = value;
        this.father = value;
    }
}
