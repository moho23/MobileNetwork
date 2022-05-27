package com.phase.firstproject.model

import java.io.Serializable

data class NoteWithId(
    var id: Int?,
    val title: String,
    val description: String
) : Serializable