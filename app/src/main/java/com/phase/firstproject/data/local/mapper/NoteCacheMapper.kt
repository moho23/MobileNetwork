package com.phase.firstproject.data.local.mapper

import com.phase.firstproject.data.local.model.LocalNote
import com.phase.firstproject.model.Note
import com.phase.firstproject.model.NoteWithId

class NoteCacheMapper {

    fun mapFrom(value: Note): LocalNote = with(value) {
        LocalNote(
            title = title,
            description = description,
        )
    }

    fun mapTo(value: LocalNote): Note = with(value) {
        Note(
            title = title,
            description = description,
        )
    }

    fun convertLocalNoteToNoteWithId(value: LocalNote): NoteWithId = with(value) {
        NoteWithId(
            title = title,
            description = description,
            id = id
        )
    }
}