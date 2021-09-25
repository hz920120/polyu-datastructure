package hk.edu.polyu.disjointset;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-25 11:13:26
 * @declaration 并查集
 * @e-mail hz920120@gmail.com
 */
public class DisjointSet<K> {

    //注册元素表
    private HashMap<K, Element<K>> registerMap;

    //元素与其代表元素映射表
    private HashMap<Element<K>, Element<K>> fatherMap;

    //代表元素所在表的元素个数
    private HashMap<Element<K>, Integer> sizeMap;

    //初始化
    public DisjointSet(HashSet<Element<K>> valueSet) {
        registerMap = new HashMap<>();
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (Element<K> k : valueSet) {
            //注册元素
            registerMap.put(k.value, k);
            //当前元素的父元素是它自己
            fatherMap.put(k, k);
            //当前元素所在集合的数量只有它自己 ：1
            sizeMap.put(k, 1);
        }
    }

    public void union(Element<K> a, Element<K> b) {

        Element<K> aFather = find(a);
        Element<K> bFather = find(b);
        //有元素不存在或者没有注册过或者属于同一个集合，无需合并
        if (find(a) == null || find(b) == null || aFather == bFather) {
            return;
        }

        int aSize = sizeMap.get(a);
        int bSize = sizeMap.get(b);

        Element<K> biggerFather = aSize >= bSize ? aFather : bFather;
        Element<K> smaller = aSize >= bSize ? b : a;
        //size小的合并到size大的

        //找到数量小的集合的代表元素（沿途元素均指向数量大的代表元素）
        while (fatherMap.get(smaller) != smaller) {
            fatherMap.put(smaller, biggerFather);
            sizeMap.put(biggerFather, sizeMap.get(biggerFather) + 1);
            sizeMap.remove(smaller);
            smaller = fatherMap.get(smaller);
        }
        //找到代表元素指向数量大的代表元素，合并完成
        fatherMap.put(smaller, biggerFather);
        sizeMap.put(biggerFather, sizeMap.get(biggerFather) + 1);
        sizeMap.remove(smaller);
    }

    public Element<K> find(Element<K> e) {
        //e==null或者从未注册过的元素，无法执行查找操作
        if (e == null || registerMap.get(e.value) == null) {
            return null;
        }

        return fatherMap.get(e);
    }

//    public static void main(String[] args) {
//        String a = "hz";
//        Element<String> ae = new Element<>(a);
//        String b = "zkn";
//        Element<String> be = new Element<>(b);
//        String c = "srf";
//        Element<String> ce = new Element<>(c);
//        String d = "lrg";
//        Element<String> de = new Element<>(d);
//        HashSet<Element<String>> set = new HashSet<>();
//        set.add(ae);
//        set.add(be);
//        set.add(ce);
//        set.add(de);
//
//        DisjointSet<String> sds = new DisjointSet<>(set);
//
//        sds.union(ae,be);
//
//        Element<String> fatherA = sds.find(ae);
//        Element<String> fatherB = sds.find(be);
//        System.out.println(fatherB == fatherA);
//        Element<String> fatherC = sds.find(ce);
//        sds.union(ae,ce);
//        Element<String> fatherD = sds.find(de);
//
//        System.out.println(1);
//    }
}
