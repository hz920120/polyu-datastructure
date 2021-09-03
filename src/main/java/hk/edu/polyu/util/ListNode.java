package hk.edu.polyu.util;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-03 14:18:09
 * @declaration Definition for singly-linked list.
 * @e-mail hz920120@gmail.com
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {

    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}