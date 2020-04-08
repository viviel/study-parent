package pers.vv.study.redis.redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

/**
 * @author guoshixiong
 */
public class MyRedissonLock {

    public static void main(String[] args) {
    }

    private void test1() {
        RedissonClient redissonClient = Redisson.create();

        RLock lock = redissonClient.getLock("");

        try {
            lock.lock();
        } finally {
            lock.unlock();
        }
    }

}
