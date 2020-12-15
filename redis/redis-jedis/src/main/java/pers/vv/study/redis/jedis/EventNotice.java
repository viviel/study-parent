package pers.vv.study.redis.jedis;

import pers.vv.study.common.Utils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class EventNotice {

    private final static String KEY = "vv:event:test";

    private final Jedis jedis = new Jedis("localhost");

    public static void main(String[] args) {
        EventNotice o = new EventNotice();
        o.run();
    }

    public EventNotice() {
        jedis.connect();
    }

    private void run() {
        Utils.cachedThreadPool().submit(this::subscribe1);
        Utils.cachedThreadPool().submit(this::subscribe2);
    }

    private void subscribe1() {
        jedis.psubscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                System.out.println("channel = " + channel + ", message = " + message);
            }

            @Override
            public void onPMessage(String pattern, String channel, String message) {
                System.out.println("pattern = " + pattern + ", channel = " + channel + ", message = " + message);
            }
        }, "*");
    }

    private void subscribe2() {
        jedis.psubscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                System.out.println("channel = " + channel + ", message = " + message);
            }

            @Override
            public void onPMessage(String pattern, String channel, String message) {
                System.out.println("pattern = " + pattern + ", channel = " + channel + ", message = " + message);
            }
        }, KEY);
    }
}
