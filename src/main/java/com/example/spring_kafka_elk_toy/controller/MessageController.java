package com.example.spring_kafka_elk_toy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

	private static final String TOPIC = "log_topic";

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@PostMapping("/publish")
	public String publishMessage(@RequestParam("message") String message) {
		kafkaTemplate.send(TOPIC, message);
		return "메시지 전송 완료: " + message;
	}
}

