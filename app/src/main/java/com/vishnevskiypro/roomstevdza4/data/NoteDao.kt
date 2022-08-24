package com.vishnevskiypro.roomstevdza4.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.vishnevskiypro.roomstevdza4.models.Note


@Dao
interface NoteDao {

    @Query("SELECT * FROM note_table")
    fun readAll(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addNote(note: Note)

    @Update
    fun updateNote(note: Note)

}