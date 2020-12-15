package pers.vv.study.redis.redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import pers.vv.study.common.Utils;

import java.util.concurrent.TimeUnit;

/**
 * @author guoshixiong
 */
public class MyRedissonLock {

    private final RedissonClient redissonClient = Redisson.create();

    public static void main(String[] args) {
        MyRedissonLock myRedissonLock = new MyRedissonLock();
        Utils.cachedThreadPool().submit(myRedissonLock::test1);
        Utils.cachedThreadPool().submit(myRedissonLock::test1);
    }

    private void test1() {
        RLock lock = redissonClient.getLock("myLock");

        try {
            lock.lock();
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            System.out.println("线程中断");
        } finally {
            lock.unlock();
        }
    }

}
