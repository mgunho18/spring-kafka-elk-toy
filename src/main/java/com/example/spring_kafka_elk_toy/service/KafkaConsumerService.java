package com.example.spring_kafka_elk_toy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

	@KafkaListener(topics = "log_topic", groupId = "spring-kafka-elk-group")
	public void listen(String message) {
		// 받은 메시지를 로그로 기록 (이 로그는 Logstash로 전송될 수 있음)
		logger.info("Kafka로부터 메시지 수신: {}", message);
	}
}

