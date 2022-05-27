package com.phase.firstproject.model

import java.io.Serializable

data class Note(
    val title: String,
    val description: String
) : Serializable