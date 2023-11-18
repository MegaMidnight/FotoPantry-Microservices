package com.fotopantry.fotopantrymediaupload.service

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class FileSendingService(private val rabbitTemplate: RabbitTemplate) {

    @Value("\${FP_UPLOAD_QUEUE}")
    private val queueName: String? = null

    fun sendFilePath(filePath: String) {
        queueName?.let { rabbitTemplate.convertAndSend(it, filePath) }
    }
}