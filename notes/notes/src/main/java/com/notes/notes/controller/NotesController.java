package com.notes.notes.controller;

import com.notes.notes.dto.NoteRequestDto;
import com.notes.notes.dto.NoteResponseDto;
import com.notes.notes.service.NotesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;

//    @GetMapping
//    public ResponseEntity<List<NoteResponseDto>> getNotes() {
//        return ResponseEntity.ok(notesService.getAllNotes());
//    }

    @GetMapping
    public ResponseEntity<Page<NoteResponseDto>> getAllNotes(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "CreatedAt, desc") String[] sort) {
        return ResponseEntity.ok(notesService.getAllNotes(page, size, sort));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteResponseDto> getNoteById(@PathVariable Long id) {
        return ResponseEntity.ok(notesService.getNoteById(id));
    }

    @PostMapping
    public ResponseEntity<NoteResponseDto> createNote(@Valid @RequestBody NoteRequestDto dto) {
        return ResponseEntity.ok(notesService.createNote(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteResponseDto> updateNote(@PathVariable Long id, @Valid @RequestBody NoteRequestDto dto) {
        return ResponseEntity.ok(notesService.updateNote(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Long id) {
        notesService.deleteNote(id);
        return ResponseEntity.ok("Note Deleted Successfully");
    }
}