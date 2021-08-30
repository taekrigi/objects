package org.my.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "test", groupId = "mygroup")
    public void consume(String message) {
        System.out.println(message);
    }
}
