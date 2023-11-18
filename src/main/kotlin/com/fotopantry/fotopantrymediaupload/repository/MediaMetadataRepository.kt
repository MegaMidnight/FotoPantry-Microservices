package com.fotopantry.fotopantrymediaupload.repository

import com.fotopantry.fotopantrymediaupload.model.MediaMetadata
import org.springframework.data.jpa.repository.JpaRepository

interface MediaMetadataRepository : JpaRepository<MediaMetadata, Long> {
    fun saveMetadata(metadata: MediaMetadata) {
        save(metadata)
    }
}