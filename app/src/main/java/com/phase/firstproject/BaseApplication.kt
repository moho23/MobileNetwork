package com.phase.firstproject

import android.app.Application
import androidx.room.Room
import com.phase.firstproject.data.local.database.AppDatabase

class BaseApplication : Application() {

    companion object {
        const val DATABASE_NAME = "ph2_database"
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this.applicationContext, AppDatabase::class.java,
            DATABASE_NAME
        )
            .allowMainThreadQueries()
            .build()
    }
}