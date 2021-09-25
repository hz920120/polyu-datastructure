package hk.edu.polyu.others;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-25 19:55:54
 * @declaration 最长回文子序列
 * @e-mail hz920120@gmail.com
 */
public class LongestPalindromeSubseq {


    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] manacherChars = formatStr(s);
        //回文半径数组
        int[] pArr = new int[manacherChars.length];
        //回文长度的下一位
        int R = -1;
        //回文中心位置
        int C = -1;
        //最长子回文串长度
        int max = Integer.MIN_VALUE;
        /*
        * 1. i在R半径外，即i > C + R，暴力验证
        * 2. i在R半径内，即i <= R ：
        *       a. 如果i在半径内部， 即i'【2C - i)】 - pArr[i] > C - R，i跳到i + pArr[i]继续验证，i点半径与i'一致
        *       b. 如果i在半径外部， 即i' - pArr[i] < C - i，i跳到R位置继续验证，i点半径为R - i
        *       c. 如果i压到边界， 即i' - pArr[i] = C - i，不确定以i为中心的回文是否结束，继续扩
        * */
        for (int i = 0; i < manacherChars.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i)  : 1;
            while (i + pArr[i] < manacherChars.length && i - pArr[i] > -1) {
                if (manacherChars[i + pArr[i]] == manacherChars[i - pArr[i]]) {
                    pArr[i]++;
                } else break;
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }

        return max - 1;
    }


    private char[] formatStr(String s) {
        int oriLen = s.length();
        int newLen = 2 * oriLen + 1;
        char[] res = new char[newLen];

        for (int i = 0; i < newLen; i++) {
            if (i % 2 == 0) {
                res[i] = '#';
            } else {
                res[i] = s.charAt((i-1) / 2);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LongestPalindromeSubseq longestPalindromeSubseq = new LongestPalindromeSubseq();
        String str = "bbbab";

        System.out.println(longestPalindromeSubseq.longestPalindromeSubseq(str));
    }
}
