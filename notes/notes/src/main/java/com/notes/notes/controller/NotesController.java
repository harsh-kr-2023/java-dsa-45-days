package com.notes.notes.controller;

import com.notes.notes.model.Note;
import com.notes.notes.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;

    @GetMapping
    public ResponseEntity<List<Note>> getNotes() {
        List<Note> notes = notesService.getAllNotes();
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        return ResponseEntity.ok(notesService.getNoteById(id));
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return ResponseEntity.ok(notesService.createNote(note));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note) {
        return ResponseEntity.ok(notesService.updateNote(id, note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Long id) {
        notesService.deleteNote(id);
        return ResponseEntity.ok("Note Deleted Successfully");
    }
}