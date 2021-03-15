package pers.vv.study.jdk.lock.distribute;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisHelper {

    public static final RedisHelper instance = new RedisHelper();

    private JedisPool pool;

    private RedisHelper() {
        pool = new JedisPool("::1", 6379);
    }

    public Jedis getJedisInstance() {
        return pool.getResource();
    }

    public void returnResource(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

}