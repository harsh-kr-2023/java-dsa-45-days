package com.notes.notes.service;

import com.notes.notes.dto.NoteRequestDto;
import com.notes.notes.dto.NoteResponseDto;
import com.notes.notes.exception.NoteNotFoundException;
import com.notes.notes.mapper.NoteMapper;
import com.notes.notes.model.Note;
import com.notes.notes.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotesService {

    @Autowired
    private NotesRepository notesRepository;

    public NoteResponseDto createNote(NoteRequestDto dto) {
        Note note = new Note();
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());
        Note saved = notesRepository.save(note);
        return mapToResponseDto(saved);
    }

//    public List<NoteResponseDto> getAllNotes() {
//        List<Note> notes = notesRepository.findAll();
//        return notes.stream().map(this::mapToResponseDto).toList();
//    }

    public Page<NoteResponseDto> getAllNotes(int page, int size, String[] sort) {
        Sort sortOrder = Sort.by(sort[0]);
        sortOrder = sort[1].equalsIgnoreCase("desc") ? sortOrder.descending() : sortOrder.ascending();

        Pageable pageable = PageRequest.of(page, size, sortOrder);

        return notesRepository.findAll(pageable).map(NoteMapper::toResponseDto);
    }

    public NoteResponseDto getNoteById(Long id) {
        Note note = notesRepository.findById(id).orElseThrow(() -> new NoteNotFoundException("Note with id " + id + " not found"));
        return mapToResponseDto(note);
    }

    public NoteResponseDto updateNote(Long id, NoteRequestDto dto) {
        Note note = notesRepository.findById(id).orElseThrow(() -> new RuntimeException("Note with id " + id + " not found"));
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        note.setUpdatedAt(LocalDateTime.now());
        Note updated = notesRepository.save(note);
        return mapToResponseDto(updated);
    }

    public void deleteNote(Long id) {
        notesRepository.deleteById(id);
    }

    private NoteResponseDto mapToResponseDto(Note note) {
        NoteResponseDto res = new NoteResponseDto();
        res.setId(note.getId());
        res.setTitle(note.getTitle());
        res.setContent(note.getContent());
        res.setCreatedAt(note.getCreatedAt());
        res.setUpdatedAt(note.getUpdatedAt());
        return res;
    }
}