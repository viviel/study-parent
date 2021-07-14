package pers.algorithm.leetcode.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 使用两个优先队列分别存储工作中的服务器以及空闲的服务器
 */
class AssignTasks2 extends AssignTasks {

    @Override
    public int[] assignTasks(int[] servers, int[] tasks) {
        //定义优先队列sq1（存入long[]{服务器标号 ， 权重}），并重写Comparator（权重从小到大，标号从小到大）
        PriorityQueue<long[]> sq1 = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return (int) (a[0] - b[0]);
            }
            return (int) (a[1] - b[1]);
        });
        //定义优先队列sq2（存入long[]{服务器标号 ， 权重 ， 服务器完成工作时间}），并重写Comparator（完成工作时间从小到大）
        PriorityQueue<long[]> sq2 = new PriorityQueue<>((a, b) -> (int) (a[2] - b[2]));
        for (int i = 0; i < servers.length; i++) {
            sq1.offer(new long[]{i, servers[i]});
        }
        int n = tasks.length;
        int[] res = new int[n];
        int r = 0;
        Deque<Integer> lst = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            //检测sq2中是否有 完成时间小于<=当前时间的服务器，若有，则从sq2中取出该服务器并加入sq1中
            while (!sq2.isEmpty() && sq2.peek()[2] <= i) {
                long[] tas = sq2.poll();
                sq1.offer(new long[]{tas[0], tas[1]});
            }
            //任务从尾部进入队列
            lst.offerLast(tasks[i]);
            //当sq1和lst都不为空时，说明有任务可以加到服务器中，此时从lst头部取出任务，并从sq1中取出服务器，两者结合后添加到sq2中
            //题目原话：如果同一时刻存在多台空闲服务器，可以同时将多项任务分别分配给它们。（很重要）
            while (!sq1.isEmpty() && !lst.isEmpty()) {
                long[] ser = sq1.poll();
                res[r++] = (int) ser[0];
                sq2.offer(new long[]{ser[0], ser[1], i + lst.pollFirst()});
            }
        }
        long t = n;
        //若是lst依旧不为空，说明服务器资源已满，需要等待
        while (!lst.isEmpty()) {
            //因此我们取出完成时间最小的所有服务器（多个服务器可能会同时解放）
            if (!sq2.isEmpty()) {
                //需把时间t置为服务器解放时间（很多超时是因为t逐一累加）
                t = sq2.peek()[2];
                while (!sq2.isEmpty() && sq2.peek()[2] == t) {
                    long[] tas = sq2.poll();
                    sq1.offer(new long[]{tas[0], tas[1]});
                }
            }
            //仿照上面把任务添加进空闲服务器
            while (!sq1.isEmpty() && !lst.isEmpty()) {
                long[] ser = sq1.poll();
                res[r++] = (int) ser[0];
                sq2.offer(new long[]{ser[0], ser[1], t + lst.pollFirst()});
            }
        }
        return res;
    }
}
