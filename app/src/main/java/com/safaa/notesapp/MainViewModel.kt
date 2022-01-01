package com.safaa.notesapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.safaa.notesapp.Data.Note
import com.safaa.notesapp.Data.NoteDao
import com.safaa.notesapp.Data.NoteDatabase
import kotlinx.coroutines.*

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val noteList: LiveData<List<Note>>
    private val noteDao :NoteDao


    init{
        noteDao = NoteDatabase.getDatabase(application).noteDao()
        noteList = noteDao.readNotes()
    }


    fun readNotes(): LiveData<List<Note>> {
        return noteList
    }

    fun addNote(noteText: String) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.saveNote(Note(0, noteText))
        }
    }

    fun editNote(selectedItem:Note) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.updateNote(selectedItem!!)
        }
    }

    fun removeNote(deletedNote:Note) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.deleteNote(Note(deletedNote!!.pk, ""))

        }
    }

}