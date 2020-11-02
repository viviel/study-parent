package pers.vv.study.jdk.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 文档
 * <li><a href="https://www.jianshu.com/p/32a15ef2f1bf">JUC源码分析-线程池篇：ForkJoinPool - 1</a></li>
 * <li><a href="https://www.jianshu.com/p/6a14d0b54b8d">JUC源码分析-线程池篇：ForkJoinPool - 2</a></li>
 */
public class MForkJoin {

    private final ForkJoinPool forkJoinPool = new ForkJoinPool();

    private static class SummationTask extends RecursiveTask<Long> {
        private final Long start;//起始值
        private final Long end;//结束值
        public static final Long critical = 100000L;//临界值

        public SummationTask(Long start, Long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            // return null;
            //判断是否是拆分完毕
            long length = end - start;   //起始值差值
            if (length <= critical) {
                //如果拆分完毕就相加
                long sum = 0L;
                for (Long i = start; i <= end; i++) {
                    sum += i;
                }
                return sum;
            } else {
                //没有拆分完毕就开始拆分
                long middle = (end + start) / 2;//计算的两个值的中间值
                SummationTask right = new SummationTask(start, middle);
                right.fork();//拆分，并压入线程队列
                SummationTask left = new SummationTask(middle + 1, end);
                left.fork();//拆分，并压入线程队列
                //合并
                return right.join() + left.join();
            }
        }
    }

    public static void main(String[] args) {
        MForkJoin m = new MForkJoin();
        m.testSummationTask();
    }

    private void testSummationTask() {
        SummationTask task = new SummationTask(0L, 1000000000L);//参数为起始值与结束值
        Long result = forkJoinPool.invoke(task);
        System.out.println(result);
    }

}
