package com.notes.notes.service;

import com.notes.notes.model.Note;
import com.notes.notes.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class NotesService {

    @Autowired
    private NotesRepository notesRepository;

    public Note createNote(Note note){
        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());
        return notesRepository.save(note);
    }

    public List<Note> getAllNotes(){
        return notesRepository.findAll();
    }

    public Note getNoteById(Long id){
        return notesRepository.findById(id).orElse(null);
    }

    public Note updateNote(Long id, Note noteData){
        Note existingNote = notesRepository.findById(id).orElse(null);
        if (existingNote == null) {
            return null;
        }
        existingNote.setTitle(noteData.getTitle());
        existingNote.setContent(noteData.getContent());
        existingNote.setUpdatedAt(LocalDateTime.now());

        return notesRepository.save(existingNote);
    }

    public void deleteNote(Long id){
        notesRepository.deleteById(id);
    }
}