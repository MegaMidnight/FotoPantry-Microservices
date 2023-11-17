package com.fotopantry.fotopantrymediaupload.listener

import com.fotopantry.fotopantrymediaupload.service.FileProcessingService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import java.nio.file.Path
import java.nio.file.Paths

@Component
class FileUploadListener(private val fileProcessingService: FileProcessingService) {

    @RabbitListener(queues = ["\${rabbitmq.queue}"])
    fun receiveMessage(message: String) {
        val path: Path = Paths.get(message)
        fileProcessingService.processFile(path)
    }
}