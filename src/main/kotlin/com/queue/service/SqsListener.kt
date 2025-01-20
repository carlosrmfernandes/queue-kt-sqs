package com.queue.service

import org.springframework.jms.annotation.JmsListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class SqsListener {

    @JmsListener(destination = "queue-sqs-test")
    fun receive(@Payload payload: String) {
        println("Received message: $payload")
    }
}
