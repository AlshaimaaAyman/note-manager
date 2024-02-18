package com.noteManagerSystem.stickynotes.model.dto;

import java.time.LocalDateTime;

import com.noteManagerSystem.stickynotes.model.enums.StickyNoteStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StickyNoteDTO {

	
    private Long id;
	
	private String description;
	
	private String name;
	
	private String color;
	
	private  StickyNoteStatus status;
	
	private  LocalDateTime createdAt;
	
	private  LocalDateTime updatedAt;
	
}
