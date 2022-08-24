package com.vishnevskiypro.roomstevdza4.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vishnevskiypro.roomstevdza4.models.Note


@Database(entities = [Note::class], version = 1, exportSchema = true)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao() : NoteDao

    companion object{

        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context) : NoteDatabase {
            val tempDb = INSTANCE
            if (tempDb != null) return tempDb

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}