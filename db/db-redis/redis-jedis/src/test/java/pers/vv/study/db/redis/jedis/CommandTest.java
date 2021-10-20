package pers.vv.study.db.redis.jedis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.Set;

public class CommandTest {

    private Jedis jedis;

    @BeforeEach
    void setUp() {
        String host = "";
        int port = 0;
        jedis = new Jedis(host, port);
    }

    @Test
    void expireTime() {
        String key = "key";
        jedis.set(key, "vv");
        jedis.expire(key, 100);
    }

    @Test
    void string() {
        String key = "key";
        jedis.set(key, "123");
        jedis.incr(key);
        jedis.decr(key);
    }

    @Test
    void list() {
        String key = "key";
        int index = 0;
        jedis.lset(key, index, "vv");
        String value = jedis.lindex(key, index);
    }

    @Test
    void set() {
        String key = "key";
        int index = 0;
        jedis.sadd(key, "vv");
        Boolean isMember = jedis.sismember(key, "vv");
    }

    @Test
    void sortedSet() {
        jedis.zadd("key", 1D, "value");
        jedis.zpopmin("key");
    }

    @Test
    void inter() {
        String key1 = "key1";
        jedis.sadd(key1, "aa", "vv");
        String key2 = "key2";
        jedis.sadd(key2, "bb", "vv");
        Set<String> inter = jedis.sinter(key1, key2);
    }

    @Test
    void map() {
        String key = "key";
        jedis.hset(key, "id1", "name");
        String name = jedis.hget(key, "id1");
    }

    @Test
    void persistence() {
        jedis.bgsave();
        jedis.bgrewriteaof();
    }

    @Test
    void subPub() {
        String channel = "pers:vv:channel";
        jedis.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                super.onMessage(channel, message);
            }
        }, channel);
        jedis.publish(channel, "msg");
    }

    @Test
    void nx() {
        jedis.setnx("key", "value");
    }

    @Test
    void slave() {
        jedis.slaveof("host", 80);
    }

    @Test
    void cluster() {
        jedis.clusterMeet("host", 80);
    }
}
