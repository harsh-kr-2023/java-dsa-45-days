package com.notes.notes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteRequestDto{

    @NotBlank(message = "Title cannot be empty")
    @Size(max = 100)
    private String title;

    @NotBlank(message = "Content cannot be empty")
    private String content;
}