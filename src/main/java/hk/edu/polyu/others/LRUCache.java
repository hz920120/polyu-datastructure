package hk.edu.polyu.others;

import java.util.*;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-14 15:24:00
 * @declaration LRU
 * @e-mail hz920120@gmail.com
 */
public class LRUCache {
    public int[] LRU (int[][] operators, int k) {
        // write code here
        if (operators == null) {
            return new int[0];
        }

        Queue<Integer> queue = new LinkedList<>();
        LRU lru  = new LRU(k);
        int x = operators.length;

        for (int i = 0; i < x; i++) {
            if (operators[i][0] == 1) {
                //set
                lru.set(operators[i][1], operators[i][2]);
            }
            if (operators[i][0] == 2) {
                //get
                queue.offer(lru.get(operators[i][1]));
            }
        }

        int size = queue.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = queue.poll();
        }
        return res;
    }


    static class LRU extends LinkedHashMap<Integer, Integer> {

        private int cp;

        public LRU (int cp) {
            super(cp, 0.75f, true);
            this.cp = cp;
        }


        public void set(int key, int value) {
            super.put(key, value);
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        @Override
        public boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
            return size() > cp;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache();
        int[][] ints = {
                {1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        int k = 3;
        lruCache.LRU(ints, k);
        System.out.println(1);
    }
}
