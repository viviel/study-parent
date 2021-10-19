package pers.vv.study.mq.pulsar;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class PulsarProducerTest extends PulsarTest {

    @Test
    public void test1() throws PulsarClientException, InterruptedException {
        Producer<String> producer = client.newProducer(Schema.STRING)
                .topic("my-topic")
                .create();

        while (!Thread.currentThread().isInterrupted()) {
            producer.send(LocalDateTime.now().toString());
            TimeUnit.SECONDS.sleep(10);
        }
    }
}
