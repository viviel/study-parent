package pers.vv.study.jdk.concurrent.fork.join;

import java.util.concurrent.RecursiveTask;

public class SummationTask extends RecursiveTask<Long> {

    private final Long start;//起始值
    private final Long end;//结束值
    public static final Long critical = 100000L;//临界值

    public SummationTask(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
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
            return left.join() + right.join();
        }
    }
}
