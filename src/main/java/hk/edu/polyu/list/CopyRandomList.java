package hk.edu.polyu.list;

import hk.edu.polyu.util.RandomNode;
import org.w3c.dom.Node;

import java.util.HashMap;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-04 15:17:41
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class CopyRandomList {

    //using hashmap
//    public RandomNode copyRandomList(RandomNode head) {
//        if (head == null) {
//            return head;
//        }
//        HashMap<RandomNode, RandomNode> map = new HashMap<>();
//        //store head and new node with the same value of head
//        RandomNode head1 = head;
//        while (head != null) {
//            RandomNode randomNode = new RandomNode(head.val);
//            map.put(head, randomNode);
//            head = head.next;
//        }
//
//        RandomNode newNode = map.get(head1);
//        //get corresponding next and random by hashmap
//        while (head1 != null) {
//            RandomNode oldNext = head1.next;
//            RandomNode oldRan = head1.random;
//            RandomNode newHead = map.get(head1);
//            newHead.next = (oldNext == null) ? null : map.get(oldNext);
//            newHead.random = (oldRan == null) ? null : map.get(oldRan);
//
//            head1 = head1.next;
//        }
//        return newNode;
//    }

    //do not using hashmap
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Node oriHead = head;
        while (head != null) {
            //1 -> 2 ======>  1 -> 1' -> 2
            Node cpNode = new Node(head.val);
            Node temp = head.next;
            head.next = cpNode;
            cpNode.next = temp;

            head = temp;
        }

        //find random
        head = oriHead;
        while (head != null) {
            Node curr = head;
            Node cpCurr = head.next;

            Node currRandom = curr.random;
            cpCurr.random = currRandom == null ? null : currRandom.next;

            head = head.next.next;
        }

        //spli new list
        head = oriHead;
        Node res = oriHead.next;
        //TODO
        while (head != null) {
            Node temp = head.next;
            head.next = temp.next;
            head = temp.next;
            temp.next = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        Node node = new Node(7);
        node.next = new Node(13);
        node.next.next = new Node(11);
        node.next.next.next = new Node(10);
        node.next.next.next.next = new Node(1);


        node.random = null;
        node.next.random = node;
        node.next.next.random = node.next.next.next.next;
        node.next.next.next.random = node.next.next;
        node.next.next.next.next.random = node;
        final CopyRandomList copyRandomList = new CopyRandomList();
        copyRandomList.copyRandomList(node);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
