package pers.algorithm.leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/sell-diminishing-valued-colored-balls/
 */
class MaxProfit {

    public int maxProfit1(int[] inventory, int orders) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparing(e -> -e));
        for (int e : inventory) {
            q.add(e);
        }
        int r = 0;
        for (int i = 0; i < orders && !q.isEmpty(); i++) {
            Integer poll = q.poll();
            r = (r + poll) % 1000000007;
            poll--;
            if (poll != 0) {
                q.add(poll);
            }
        }
        return r;
    }

    public int maxProfit2(int[] inventory, int orders) {
        Integer[] array = Arrays.stream(inventory).boxed().toArray(Integer[]::new);
        Arrays.sort(array, Collections.reverseOrder());
        int r = 0;
        int i2 = 0;
        while (orders != 0) {
            while (i2 + 1 < array.length && array[i2].equals(array[i2 + 1])) {
                i2++;
            }
            for (int i = 0; i <= i2 && orders != 0; i++) {
                r = (r + array[i]--) % 1000000007;
                orders--;
            }
        }
        return r;
    }

    public int maxProfit(int[] inventory, int orders) {
        return 0;
    }
}
