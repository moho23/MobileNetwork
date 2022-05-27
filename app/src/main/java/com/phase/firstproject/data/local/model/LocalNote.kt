package com.phase.firstproject.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class LocalNote(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String,
    val description: String
)