package pers.vv.study.mq.pulsar;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;

public class PulsarConsumer {

    public static void main(String[] args) throws PulsarClientException {
        Thread mainThread = Thread.currentThread();

        PulsarClient client = PulsarClient.builder()
                .serviceUrl("pulsar://localhost:6650")
                .build();

        Consumer<String> consumer = client.newConsumer(Schema.STRING)
                .topic("my-topic")
                .subscriptionName("my-subscription")
                .subscribe();
        while (!mainThread.isInterrupted()) {
            // Wait for a message
            Message<String> msg = consumer.receive();
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

}
