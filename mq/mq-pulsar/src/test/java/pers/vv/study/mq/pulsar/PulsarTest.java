package pers.vv.study.mq.pulsar;

import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.junit.jupiter.api.BeforeAll;

public class PulsarTest {

    static PulsarClient client;

    @BeforeAll
    public static void before() throws PulsarClientException {
        client = PulsarClient.builder()
                .serviceUrl("pulsar://localhost:6650")
                .build();
    }
}
