package hk.edu.polyu.list;

import hk.edu.polyu.util.ListNode;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-04 09:58:30
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class IsPalindrome {

    //using stack
//    public boolean isPalindrome(ListNode head) {
//        if (head == null || head.next == null) {
//            return true;
//        }
//        ListNode newHead = head;
//        Stack<ListNode> stack = new Stack<>();
//        while (head != null) {
//            stack.add(head);
//            head = head.next;
//        }
//
//        int size = stack.size() / 2;
//        for (int i = 0; i < size; i++) {
//            if (stack.pop().val == newHead.val) {
//                newHead = newHead.next;
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }

    //using double pointer(a slow and a fast)
//    public boolean isPalindrome(ListNode head) {
//        if (head == null || head.next == null) {
//            return true;
//        }
//
//        ListNode s = head;
//        ListNode f = head;
//        Stack<ListNode> stack = new Stack<>();
//        while (f != null && f.next != null) {
//            stack.add(s);
//            s = s.next;
//            f = f.next.next;
//        }
//
//        if (f != null) {
//            s = s.next;
//        }
//
//        while (!stack.isEmpty()) {
//            if (stack.pop().val != s.val) {
//                return false;
//            } else {
//                s = s.next;
//            }
//        }
//        return true;
//    }

    //using no extra space, extra Space: O(1)
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode s = head;
        ListNode f = head;

        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }

        f = s.next;
        s.next = null;
        //s is in the middle
        ListNode temp;
        while (f != null) {
            temp = f.next;
            f.next = s;
            s = f;
            f = temp;
        }

        boolean res = true;
        while (s != null && head != null) {
            if (s.val != head.val) {
                res = false;
                break;
            } else {
                s = s.next;
                head = head.next;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        IsPalindrome isPalindrome = new IsPalindrome();
        isPalindrome.isPalindrome(head);
        System.out.println(1);
    }
}
