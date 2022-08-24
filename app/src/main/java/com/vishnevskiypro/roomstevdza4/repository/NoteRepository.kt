package com.vishnevskiypro.roomstevdza4.repository

import androidx.lifecycle.LiveData
import com.vishnevskiypro.roomstevdza4.data.NoteDao
import com.vishnevskiypro.roomstevdza4.models.Note

class NoteRepository(val noteDao: NoteDao) {

    val readAllNotes: LiveData<List<Note>> = noteDao.readAll()

    fun addNote(note: Note){
        noteDao.addNote(note)
    }

    fun updateNote(note: Note){
        noteDao.updateNote(note)
    }

}