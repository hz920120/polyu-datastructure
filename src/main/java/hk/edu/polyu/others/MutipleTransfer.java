package hk.edu.polyu.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-15 22:07:54
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class MutipleTransfer {
    /*
    * 规定1和A对应、2和B对应、3和C对应。。。。。
    * 那么数字字符串比如"111"，可以转化为"AAA" "KA"  "AK"
    * 给定只有数字的字符串，返回有多少种转化结果
    *
    * */

    static HashMap<String, String> letterMap = new HashMap<>();

    static {
        int num = 'a';
        for (int i = 0; i <= 25; i++) {
            letterMap.put(i + "", (char) (num + i) + "");
        }
    }



    public List<String> getSum(int str) {
        List<String> res = new ArrayList<>();
        getStr("", str+"", res);
        return res;
    }

    public void getStr(String pre,String change, List<String> res) {
        if (change == null || change.length() == 0) {
            res.add(pre);
            return;
        }

        if (change.length() == 1) {
            String or = letterMap.get(change);
            res.add(pre + or);
            return;
        }

        String str1 = change.substring(0,1);
        getStr(pre + letterMap.get(str1), change.substring(1), res);
        String str3 = change.substring(0,2);
        if (letterMap.get(str3) != null) {
            getStr(pre + letterMap.get(str3), change.substring(2), res);
        }
    }


    public static void main(String[] args) {
        MutipleTransfer mutipleTransfer = new MutipleTransfer();
        List<String> res = mutipleTransfer.getSum(26);

        String str = "";
//        System.out.println(str.charAt(0));
//        System.out.println(str.substring(2,3));
//        System.out.println(str.substring(0,2));
//        System.out.println(str.substring(2));
//        System.out.println(str.substring(1));
    }
}
