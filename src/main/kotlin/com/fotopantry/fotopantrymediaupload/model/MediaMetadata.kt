package com.fotopantry.fotopantrymediaupload.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.Instant

@Entity
data class MediaMetadata(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    val creationTime: Instant,
    val lastModifiedTime: Instant,
    val size: Double,
    val filePath: String
)