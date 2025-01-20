package com.queue

import com.queue.service.SqsService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sqs")
class SqsController(
    private val sqsService: SqsService
) {

    @PostMapping("/send")
    fun sendMessage(@RequestBody message: String) {
        sqsService.sendMessageToQueue(message)
    }
}