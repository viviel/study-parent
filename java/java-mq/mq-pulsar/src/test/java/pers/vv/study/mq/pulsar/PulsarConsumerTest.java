package pers.vv.study.mq.pulsar;

import org.apache.pulsar.client.api.*;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class PulsarConsumerTest extends PulsarTest {

    private <T> void consume(Consumer<T> consumer) throws PulsarClientException {
        while (!Thread.currentThread().isInterrupted()) {
            // Wait for a message
            Message<T> msg = consumer.receive();
            try {
                // Do something with the message
                System.out.printf("Message received: %s\n", msg.getValue());
                // Acknowledge the message so that it can be deleted by the message broker
                consumer.acknowledge(msg);
            } catch (Exception e) {
                // Message failed to process, redeliver later
                consumer.negativeAcknowledge(msg);
            }
        }
    }

    @Test
    void test1() throws PulsarClientException {
        Consumer<String> consumer = client.newConsumer(Schema.STRING)
                .topic("my-topic")
                .subscriptionName("my-subscription1")
                .subscriptionType(SubscriptionType.Shared)
                .negativeAckRedeliveryDelay(1, TimeUnit.SECONDS)
                .subscribe();
        consume(consumer);
    }

    @Test
    void test2() throws PulsarClientException {
        Consumer<String> consumer = client.newConsumer(Schema.STRING)
                .topic("my-topic")
                .subscriptionName("my-subscription1")
                .subscriptionType(SubscriptionType.Shared)
                .negativeAckRedeliveryDelay(1, TimeUnit.SECONDS)
                .subscribe();
        consume(consumer);
    }
}
