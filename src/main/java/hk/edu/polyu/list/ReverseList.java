package hk.edu.polyu.list;

import hk.edu.polyu.util.ListNode;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-03 14:20:03
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class ReverseList {


    /**
     * do not consider extra space complexity
     * @param head
     * @return
     */
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        Stack<ListNode> stack = new Stack<>();
//        while (head != null) {
//            stack.push(new ListNode(head.val));
//            head = head.next;
//        }
//
//        head = stack.pop();
//        ListNode res = head;
//
//        while (!stack.isEmpty()) {
//            System.out.println("res:" + res);
//            head.next = stack.pop();
//            head = head.next;
//            System.out.println("head" + head);
//        }
//        return res;
//    }

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;

        while (head != null) {
            ListNode temp = pre;
            pre = head;
            head = head.next;
            pre.next = temp;
        }

        return pre;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseList reverseList = new ReverseList();
        reverseList.reverseList(head);
    }
}
