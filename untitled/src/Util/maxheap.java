package Util;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import static Util.PrintDictionaryKt.printDictionary;

public class maxheap {
    public static void main(String[] args) {
        int k = 4;
        int[] nums = {1, 2, 3, 4};
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        printDictionary((HashMap<?, ?>) count);

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
        for (int n: count.keySet()) {
            heap.add(n);
//            if (heap.size() > k) heap.poll();
        }
        System.out.println(heap.poll());

    }
}
