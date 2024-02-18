package com.noteManagerSystem.stickynotes.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.noteManagerSystem.stickynotes.model.dto.AddStickyNoteDTO;
import com.noteManagerSystem.stickynotes.model.dto.NoteDTO;
import com.noteManagerSystem.stickynotes.model.dto.StickyNoteDTO;
import com.noteManagerSystem.stickynotes.model.dto.UpdateStickyNoteDTO;
import com.noteManagerSystem.stickynotes.model.entity.StickyNoteEntity;
import com.noteManagerSystem.stickynotes.model.enums.StickyNoteStatus;

@Service
public interface StickyNoteService {

	 AddStickyNoteDTO addStickyNote(AddStickyNoteDTO dto);
	 	 
	 StickyNoteDTO findById(Long id);
	 
	 void update(UpdateStickyNoteDTO dto, Long id);
	 
	 List<StickyNoteDTO> allStickyNotes(StickyNoteStatus status);
	
	 
	 
}
