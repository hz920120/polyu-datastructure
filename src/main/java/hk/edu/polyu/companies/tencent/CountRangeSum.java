package hk.edu.polyu.companies.tencent;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-23 10:57:04
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class CountRangeSum {
    /*
    * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
    * */

    public int rangeBitwiseAnd(int left, int right) {
        if (left == 0) return 0;
        int count = 1;
        int temp = left;
        while (left != 0) {
            left >>>= 1;
            count++;
        }

        int[] bu = new int[count];
        bu[0] = temp & 1;
        for (int i = 1; i < count; i++) {
            bu[i] = (temp >>> i) & 1;
        }

        for (int i = temp + 1; i <= right; i++) {
            int pos = onesPosition(bu);
            int change = 1 << pos;
            i = Math.max(change, i);
            if (pos == -1) {
                return 0;
            } else {
                updateBu(bu, i, pos);
            }
        }

        int res = 0;
        for (int i = 0; i < bu.length; i++) {
            if (bu[i] == 1) {
                res += 1 << i;
            }
        }
        return res;
    }

    public int onesPosition(int[] bu) {
        for (int i = 0; i < bu.length; i++) {
            if (bu[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    private void updateBu(int[] bu, int num, int start) {
        for (int i = start; i < bu.length; i++) {
            int temp = num;
            if (bu[i] == 1) {
                bu[i] = (temp >>> i) & bu[i];
            }
        }
    }

    public static void main(String[] args) {
        CountRangeSum countRangeSum = new CountRangeSum();
        System.out.println(countRangeSum.rangeBitwiseAnd(600000000, 2147483645));
    }
}
