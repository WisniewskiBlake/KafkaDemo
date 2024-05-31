package com.example.aisearchenginemicroservice.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "user_queries", groupId = "user_queries_group")
    public void listen(ConsumerRecord<String, String> record) {
        System.out.printf("Received record (key: %s, value: %s, partition: %d, offset: %d)%n",
                record.key(), record.value(), record.partition(), record.offset());
    }
}
