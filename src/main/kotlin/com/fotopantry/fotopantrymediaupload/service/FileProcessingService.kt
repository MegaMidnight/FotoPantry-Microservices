package com.fotopantry.fotopantrymediaupload.service

import com.fotopantry.fotopantrymediaupload.model.MediaMetadata
import com.fotopantry.fotopantrymediaupload.repository.MediaMetadataRepository
import org.springframework.stereotype.Service
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.attribute.BasicFileAttributes
import java.time.Instant

@Service
class FileProcessingService(
    private val fileSendingService: FileSendingService,
    private val mediaMetadataRepository: MediaMetadataRepository
) {

    fun processFile(path: Path) {
        val fileSizeInBytes = Files.size(path)
        val fileSizeInGB = fileSizeInBytes / (1024.0 * 1024.0 * 1024.0)

        if (fileSizeInGB > 2) {
            throw IllegalArgumentException("File size is more than 2GB")
        }

        val attr = Files.readAttributes(path, BasicFileAttributes::class.java)

        val mediaMetaData = MediaMetadata(
            creationTime = Instant.ofEpochMilli(attr.creationTime().toMillis()),
            lastModifiedTime = Instant.ofEpochMilli(attr.lastModifiedTime().toMillis()),
            size = fileSizeInGB,
            filePath = path.toString()
        )

        mediaMetadataRepository.saveMetadata(mediaMetaData)

        // Send the file path to FileSendingService for further processing
        fileSendingService.sendFilePath(path.toString())
    }
}