package com.noteManagerSystem.stickynotes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.noteManagerSystem.stickynotes.model.dto.AddNoteDTO;
import com.noteManagerSystem.stickynotes.model.dto.NoteDTO;
import com.noteManagerSystem.stickynotes.model.dto.StickyNoteDTO;

@Service
public interface NoteService {
	
	 NoteDTO addNote(AddNoteDTO dto, Long stickyNoteId);
	
	 List<NoteDTO> getAllNotesByStickyNoteId(Long stickyNoteId);
	 
	 void deleteById(Long noteId);
	 
	 List<NoteDTO> myNotes();
	 

}
