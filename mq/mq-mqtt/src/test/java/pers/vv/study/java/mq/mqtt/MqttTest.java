package pers.vv.study.java.mq.mqtt;

import org.fusesource.mqtt.client.*;
import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;

public class MqttTest {

    private final String topic = "persistent://public/default/my-topic";

    @Test
    void test1() throws Exception {
        MQTT mqtt = new MQTT();
        mqtt.setHost("127.0.0.1", 1883);
        BlockingConnection connection = mqtt.blockingConnection();
        connection.connect();
        Utils.cachedThreadPool().execute(() -> {
            try {
                publish(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Utils.cachedThreadPool().execute(() -> {
            try {
                subscribe(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Utils.block();
    }

    private void publish(BlockingConnection connection) throws Exception {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String msg = "Hello MOP! - " + i;
            connection.publish(topic, msg.getBytes(), QoS.AT_LEAST_ONCE, false);
            Utils.sleep(1000);
        }
    }

    private void subscribe(BlockingConnection connection) throws Exception {
        Topic[] topics = {new Topic(topic, QoS.AT_LEAST_ONCE)};
        connection.subscribe(topics);
        while (!Thread.interrupted()) {
            Message msg = connection.receive();
            System.out.println(msg);
        }
    }
}
