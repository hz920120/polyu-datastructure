package hk.edu.polyu.comp5112;

import java.util.*;

/**
 * @author HUANG Zuo
 * @version create_time：2021-11-22 10:29:48
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class CalCandidateKey {


    public static Set<String> getCandidateKeys(String relationModel, String relationship) {
        //step1: find L、R、LR、N
        String[] relation = relationship.split(",");
        HashMap<String, String> getRelationMap = getRelationMap(relation);
        String[] allRelation = relationModel.split(",");
        HashMap<String, Set<String>> LAndR = getLAndR(relation);
        //get all the left elements of "->"
        Set<String> setL = LAndR.get("L");
        //get all the right elements of "->"
        Set<String> setR = LAndR.get("R");
        //get all the elements of both sides
        Set<String> setAll = getAll(setL, setR);
        //get all the elements which are only on the left
        Set<String> L = getOnlyL(setL, setR);
        //get all the elements which are only on the right
        Set<String> R = getOnlyR(setL, setR);
        //get all the elements which are on the both sides
        Set<String> LR = getLR(setL, setR);
        //get all the elements which are not on the both sides
        Set<String> N = getN(allRelation, setAll);

        //step2: let X = L ∪ N, verify whether D+ is a candidate key
        Set<String> X = getAll(L, N);
        Set<String> closureX = getClosure(X, getRelationMap);

        Set<String> res = new HashSet<>();
        //if equals, X is the only candidate key
        if (equals(closureX, setAll)) {
            StringBuilder key = new StringBuilder();
            for (String s : X) {
                key.append(s);
            }
            res.add(key.toString());
            return res;
        }

        //step3: traverse the set LR until it is empty or has no more child String
        int len = 1;
        while (!LR.isEmpty()) {
            Set<String> resSet = new HashSet<>();
            getChildString(getString(LR), 0, "", len, resSet);

            if (resSet.isEmpty()) {
                break;
            }
            for (String child : resSet) {
                Set<String> temp = new HashSet<>(X);
                temp.add(child);
                Set<String> closure = getClosure(temp, getRelationMap);
                if (equals(closure, setAll)) {
                    StringBuilder key = new StringBuilder();
                    for (String s : temp) {
                        key.append(s);
                    }
                    removeElements(LR, child);
                    res.add(key.toString());
                }
            }
            len++;
        }

        return res;
    }

    private static void removeElements(Set<String> ori, String str) {
        Arrays.asList(str.split("")).forEach(ori::remove);
    }

    private static String getString(Set<String> LR) {
        StringBuilder res = new StringBuilder();
        for (String str : LR) {
            res.append(str);
        }
        return res.toString();
    }

    public static void getChildString(String str, int index, String lastR, int len, Set<String> res){
        char[] chars = str.toCharArray();
        if (index == chars.length){//index代表当前遍历的字符在字符串的位置
            if (lastR.length() == len) {
                System.out.println(len + " child string is");
                System.out.println(lastR);
                res.add(lastR);
            }
            return;
        }
        getChildString(str,index+1,lastR+ chars[index], len, res);//传当前元素
        getChildString(str,index+1,lastR, len, res);//不传当前元素
    }

    private static HashMap<String, String> getRelationMap(String[] relation) {
        HashMap<String, String> res = new HashMap<>();
        for (String str : relation) {
            String L = str.substring(0, str.indexOf("-"));
            String R = str.substring(str.indexOf(">") + 1);
            res.put(L, R);
        }
        return res;
    }

    private static Set<String> getN(String[] allRelation, Set<String> setAll) {
        Set<String> res = new HashSet<>();
        for (String rel : allRelation) {
            if (!setAll.contains(rel)) {
                res.add(rel);
            }
        }
        return res;
    }

    private static Set<String> getAll(Set<String> setL, Set<String> setR) {
        Set<String> res = new HashSet<>();
        res.addAll(setL);
        res.addAll(setR);
        return res;
    }

    private static Set<String> getLR(Set<String> setL, Set<String> setR) {
        Set<String> res = new HashSet<>();
        for (String L : setL) {
            if (setR.contains(L)) {
                res.add(L);
            }
        }
        return res;
    }

    private static Set<String> getOnlyR(Set<String> setL, Set<String> setR) {
        Set<String> res = new HashSet<>();
        for (String R : setR) {
            if (!setL.contains(R)) {
                res.add(R);
            }
        }
        return res;
    }

    private static Set<String> getOnlyL(Set<String> setL, Set<String> setR) {
        Set<String> res = new HashSet<>();
        for (String L : setL) {
            if (!setR.contains(L)) {
                res.add(L);
            }
        }
        return res;
    }

    private static HashMap<String, Set<String>> getLAndR(String[] relation) {
        HashMap<String, Set<String>> res = new HashMap<>();
        Set<String> setL = new HashSet<>();
        Set<String> setR = new HashSet<>();
        for (String str : relation) {
            String L = str.substring(0, str.indexOf("-"));
            String R = str.substring(str.indexOf(">") + 1);
            setL.addAll(Arrays.asList(L.split("")));
            setR.addAll(Arrays.asList(R.split("")));
        }
        res.put("L", setL);
        res.put("R", setR);
        return res;
    }

    private static Set<String> getClosure(Set<String> relSet,HashMap<String,String> fs) {
        boolean bflag=true;
        String result = "";
        for (String rel : relSet) {
            result += rel;
        }
        while (bflag) {
            bflag=false;
            for(String s: fs.keySet()) {
                //依次取出每个函数依赖的左部
                //如果左部包含在已求出的闭包中
                if (isInclude(s,result)) {
                    //则将函数依赖的右部也放入闭包中
                    String str = addStr(fs.get(s),result);
                    if (!result.equals(str)) {
                        //如果放入右部后，闭包有变化，则更新闭包
                        result = str;
                        //并设置需要再次循环的标志
                        bflag = true;
                    }
                }
            }
        }
        Set<String> res = new HashSet<>();
        res.addAll(Arrays.asList(result.split("")));
        return res;
    }

    private static boolean equals(Set<?> set1, Set<?> set2){
        if(set1 == null || set2 ==null){//null就直接不比了
            return false;
        }
        if(set1.size()!=set2.size()){//大小不同也不用比了
            return false;
        }
        return set1.containsAll(set2);//最后比containsAll
    }

    private static String addStr(String small, String big){
        StringBuilder str = new StringBuilder(big);
        for (int i=0;i<small.length();i++) {
            if (big.indexOf(small.charAt(i)) == -1) {
                str.append(small.charAt(i));
            }
        }
        return str.toString();
    }


    //测试str1中的每个字符是否都包含在str2中
    //例如 isInclude("BE","ABCE") return true
    private static boolean isInclude(String str1 ,String str2) {
        boolean flag = true;
        for (int i = 0; i < str1.length(); i++) {
            if (str2.indexOf(str1.charAt(i)) == -1) {
                flag = false;
                break;
            }
        }
        return flag;
    }


    public static void main(String[] args) {
//        Set<String> res = getCandidateKeys("A,B,C,D","A->BC,BC->A,BCD->EF,E->C");
        Set<String> res = getCandidateKeys("A,B,C,D,E","AB->E,D->C");
        System.out.println("result---------");
        for (String key : res) {
            System.out.println(key);
        }
    }
}
