package com.noteManagerSystem.stickynotes.model.dto;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteDTO {

	
	private Long id;
	private String note;	
	private Long stickyNoteId;	
	private  LocalDateTime createdAt;
	private  LocalDateTime updatedAt;
	// private  LocalDateTime deletedAt;
}
