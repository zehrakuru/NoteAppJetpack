package com.example.noteapp.domain.usecase

/*import com.example.noteapp.domain.model.InvalidNoteException
import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {

        if(note.title.isBlank()) {
            throw InvalidNoteException("The title of the note cannot be blank.")
        }

        if(note.content.isBlank()) {
            throw InvalidNoteException("The content of the note cannot be blank.")
        }

        repository.insertNote(note)
    }
}*/