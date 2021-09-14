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

        char[] chars = A.toCharArray();

        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            res = Math.max(1 + findCenter(chars, i ,1), findSides(chars, i - 1, i + 1));
        }

        return res;
    }

    public int findCenter(char[] chars, int index, int d) {
        if (index - d < 0 || index + d > chars.length - 1) {
            return 0;
        }
        if (chars[index - d] == chars[index + d]) {
            return 2 + findCenter(chars, index, d + 1);
        }
        return 0;
    }

    public int findSides(char[] chars, int left, int right) {
        if (left < 0 || right > chars.length - 1) {
            return 0;
        }

        if (chars[left] == chars[right]) {
            return 2 + findSides(chars, left, chars.length - left);
        }
        return 0;
    }

    public static void main(String[] args) {
        String in = "baabccc";
        GetLongestPalindrome getLongestPalindrome = new GetLongestPalindrome();
        int res = getLongestPalindrome.getLongestPalindrome(in, in.length());
        System.out.println(res);
    }


}
