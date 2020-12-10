package pers.vv.study.redis.redisson.maperror;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.codec.FstCodec;
import org.redisson.config.Config;

import java.io.Serializable;
import java.util.stream.IntStream;

public class RedissonMapError {

    private static final String RK = "vv:test";

    private RedissonClient redisson;

    @Data
    private static class RedisData implements Serializable {

        private Integer id;
        private String name;
        private String text;

        RedisData(Integer id, String name) {
            this.id = id;
            this.name = name;
            this.text = id + name;
        }
    }

    public static void main(String[] args) {
        RedissonMapError o = new RedissonMapError();
        o.test();
    }

    private void test() {
        try {
            createRedisson();
//            clearData();
            prepareData();
            exe();
        } finally {
            shutdown();
        }
    }

    private void createRedisson() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");
        config.setCodec(new FstCodec());
        redisson = Redisson.create(config);
    }

    private RMap<String, RedisData> getMap() {
        return redisson.getMap(RK);
    }

    private void clearData() {
        getMap().clear();
    }

    private void prepareData() {
        RMap<String, RedisData> map = getMap();
        IntStream.range(0, 10).forEach(e -> {
            String key = String.format("/%s", e);
            map.putIfAbsent(key, new RedisData(e, key));
        });
    }

    private void exe() {
        RMap<String, RedisData> map = getMap();
        System.out.println(map.size());
        System.out.println(map.get("/0"));
        System.out.println(map.get("/10"));
        System.out.println(map.keySet());
        System.out.println(map.readAllKeySet());
    }

    private void shutdown() {
        redisson.shutdown();
    }
}
