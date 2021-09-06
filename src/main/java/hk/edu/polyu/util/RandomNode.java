package hk.edu.polyu.util;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-03 14:18:09
 * @declaration Definition for singly-linked list.
 * @e-mail hz920120@gmail.com
 */
public class RandomNode {
    public int val;
    public RandomNode next;
    public RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}