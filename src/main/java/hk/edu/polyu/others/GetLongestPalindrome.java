package hk.edu.polyu.others;

import java.util.*;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-14 19:04:10
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class GetLongestPalindrome {

    public int getLongestPalindrome(String A, int n) {
        if (A == null || A.length() == 0 || n == 0) {
            return 0;
        }

        String reverse = new StringBuilder(A).reverse().toString();

        Stack<Character> stack = new Stack<>();
        LinkedList<Character> list = new LinkedList<>();

        //正序
        char[] pos = A.toCharArray();
        //倒序
        char[] neg = reverse.toCharArray();

        for (char c : pos) {
            list.offer(c);
        }

        for (char c : neg) {
            stack.push(c);
        }

        int res = 0;

        for (int i = 0; i < list.size(); i++) {
            if (res >= list.size() - i) {
                return res;
            }

            Stack<Character> s = new Stack<>();
            s.addAll(stack);
            LinkedList<Character> l = new LinkedList<>(list);

            for (int j = 0; j < i; j++) {
                s.pop();
            }

            int temp = 0;
            while (!s.isEmpty()) {
                char schar = s.pop();
                char lchar = l.pollLast();
                if (schar == lchar) {
                    res = Math.max(++temp, res);
                } else {
                    temp = 0;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String in = "baabccc";
        GetLongestPalindrome getLongestPalindrome = new GetLongestPalindrome();
        int res = getLongestPalindrome.getLongestPalindrome(in, in.length());
        System.out.println(res);
    }


}
