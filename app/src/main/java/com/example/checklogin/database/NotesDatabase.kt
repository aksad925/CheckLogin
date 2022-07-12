package com.example.checklogin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities =[Notes::class], version = 1)
abstract class NotesDatabase:RoomDatabase() {

    abstract  fun notesDao() :NotesDao

    lateinit var INSTANCE:NotesDatabase
    fun getInstance(context:Context):NotesDatabase {
        synchronized(NotesDatabase::class)
        {
            INSTANCE= Room.databaseBuilder(context.applicationContext,NotesDatabase::class.java,"NotesDB")
                .allowMainThreadQueries().build()
        }
        return INSTANCE
    }
}