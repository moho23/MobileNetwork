package com.phase.firstproject.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.phase.firstproject.data.local.dao.NoteDao
import com.phase.firstproject.data.local.model.LocalNote

@Database(entities = [LocalNote::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
}