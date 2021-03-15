package pers.vv.study.mq.pulsar;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class PulsarProducer {

    public static void main(String[] args) throws PulsarClientException, InterruptedException {
        PulsarClient client = PulsarClient.builder()
                .serviceUrl("pulsar://localhost:6650")
                .build();

        Producer<String> producer = client.newProducer(Schema.STRING)
                .topic("my-topic")
                .create();
        while (!Thread.currentThread().isInterrupted()) {
            producer.send(LocalDateTime.now().toString());
            TimeUnit.SECONDS.sleep(5);
        }
    }

}
