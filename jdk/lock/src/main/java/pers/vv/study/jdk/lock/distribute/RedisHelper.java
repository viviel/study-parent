package pers.vv.study.jdk.lock.distribute;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisHelper {

    public static final RedisHelper instance = new RedisHelper();
    private JedisPool pool;

    {
        pool = new JedisPool("10.17.1.61", 6506);
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