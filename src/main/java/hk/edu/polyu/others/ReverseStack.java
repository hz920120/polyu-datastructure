package hk.edu.polyu.others;

import java.util.Stack;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-15 15:34:04
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class ReverseStack {

    /*
    * 给你一个栈，请你逆序这个栈，不能申请额外的数据结构，如何实现？
    * */

    public void reverseStack(Stack<Integer> ori) {

        if (ori == null ||ori.isEmpty()) {
            return;
        }
        Integer currLast = getLast(ori);
        if (ori.isEmpty()) {
            ori.push(currLast);
        } else {
            reverseStack(ori);
            ori.push(currLast);
        }
    }

    public Integer getLast(Stack<Integer> stack) {
        if (stack == null || stack.isEmpty()) {
            return null;
        }

        Integer curr = stack.pop();
        if (stack.isEmpty()) {
            return curr;
        } else {
            Integer last = getLast(stack);
            stack.push(curr);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        integers.push(1);
        integers.push(2);
        integers.push(3);
        ReverseStack reverseStack = new ReverseStack();
        reverseStack.reverseStack(integers);
        while (!integers.isEmpty()) {
            System.out.println(integers.pop());
        }
    }
}
