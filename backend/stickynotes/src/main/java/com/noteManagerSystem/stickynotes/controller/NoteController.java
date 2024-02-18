package com.noteManagerSystem.stickynotes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noteManagerSystem.stickynotes.model.dto.AddNoteDTO;
import com.noteManagerSystem.stickynotes.model.dto.NoteDTO;
import com.noteManagerSystem.stickynotes.service.NoteService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {
	
	private final NoteService noteService ;
	
	@PostMapping("/add/{stickyNoteId}")
	public String addNote(@ModelAttribute("dto")  AddNoteDTO dto, @PathVariable Long stickyNoteId ) {
		  this.noteService.addNote(dto, stickyNoteId);
		  return "redirect:/sticky-note/" + stickyNoteId;

	}
	
	@GetMapping("/delete/{noteId}/{stickyNoteId}")
	public String deleteById(@PathVariable("noteId") Long noteId, @PathVariable("stickyNoteId") Long stickyNoteId) {
		this.noteService.deleteById(noteId);	
		return "redirect:/sticky-note/" + stickyNoteId;
	}

}

