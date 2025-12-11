package com.notes.notes.mapper;

import com.notes.notes.dto.NoteRequestDto;
import com.notes.notes.dto.NoteResponseDto;
import com.notes.notes.model.Note;

public class NoteMapper {
    public static Note toEntity(NoteRequestDto dto) {
        Note note = new Note();
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        return note;
    }

    public static NoteResponseDto toResponseDto(Note note) {
        NoteResponseDto dto = new NoteResponseDto();
        dto.setId(note.getId());
        dto.setTitle(note.getTitle());
        dto.setContent(note.getContent());
        dto.setCreatedAt(note.getCreatedAt());
        dto.setUpdatedAt(note.getUpdatedAt());
        return dto;
    }
}