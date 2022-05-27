package com.phase.firstproject.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.phase.firstproject.data.local.model.LocalNote

@Dao
interface NoteDao {

    @Insert
    fun insert(note: LocalNote)

    @Query("SELECT * FROM note")
    fun getAll(): List<LocalNote>

    @Query("DELETE FROM note WHERE id = :id")
    fun deleteNote(id: Int?)

    @Query("update note set title = :title , description = :text where id = :id")
    fun updateNote(id: Int?, title: String, text: String)
}