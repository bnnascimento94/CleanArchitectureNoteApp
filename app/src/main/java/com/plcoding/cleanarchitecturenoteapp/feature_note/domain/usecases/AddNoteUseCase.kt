package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.usecases

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.InvalidNoteException
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNoteUseCase(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if(note.title.isBlank()){
            throw InvalidNoteException("The Title of the note can´t be empty.")
        }
        if(note.content.isBlank()){
            throw  InvalidNoteException("The content of the note can't be empty.")
        }
        repository.insertNote(note)
    }
}