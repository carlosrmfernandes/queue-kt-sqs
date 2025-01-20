package com.queue.service

import com.amazonaws.services.sqs.AmazonSQS
import com.amazonaws.services.sqs.model.SendMessageRequest
import org.springframework.stereotype.Service

@Service
class SqsService(
    private val amazonSQS: AmazonSQS,
) {
    private val queueUrl = "http://localhost:4566/000000000000/queue-sqs-test"

    fun sendMessageToQueue(message: String) {
        val request = SendMessageRequest(queueUrl, message)
        amazonSQS.sendMessage(request)
    }
}