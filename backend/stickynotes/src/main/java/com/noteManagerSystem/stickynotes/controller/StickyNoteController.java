package com.noteManagerSystem.stickynotes.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.noteManagerSystem.stickynotes.model.dto.AddStickyNoteDTO;
import com.noteManagerSystem.stickynotes.model.dto.NoteDTO;
import com.noteManagerSystem.stickynotes.model.dto.StickyNoteDTO;
import com.noteManagerSystem.stickynotes.model.dto.UpdateStickyNoteDTO;
import com.noteManagerSystem.stickynotes.model.enums.StickyNoteStatus;
import com.noteManagerSystem.stickynotes.service.NoteService;
import com.noteManagerSystem.stickynotes.service.StickyNoteService;
import com.noteManagerSystem.stickynotes.service.serviceImpl.StickyNoteServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StickyNoteController {
	
	private final StickyNoteServiceImpl impl;
	private final StickyNoteService stickyNoteservice;
	private final NoteService noteService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<StickyNoteDTO> dtos = this.stickyNoteservice.allStickyNotes(StickyNoteStatus.ACTIVE);
		model.addAttribute("StickyNotes",dtos);
		return "home";
	}
	
	@GetMapping("my-notes")
	public String myNotes(Model model) {
		List<NoteDTO> dtos = this.noteService.myNotes();
		model.addAttribute("notes",dtos);
		return "my-notes";
	}
	
	
	@GetMapping("/sticky-note/{id}")
	public String stickyNote(@PathVariable(name= "id") Long id, Model model) {
		StickyNoteDTO stickyNote = this.stickyNoteservice.findById(id); 
		List<NoteDTO> notes = this.noteService.getAllNotesByStickyNoteId(id);
		model.addAttribute("StickyNote", stickyNote);
		model.addAttribute("notes", notes);
		return "sticky-note";
	}
	
	@GetMapping("/sticky-note/edit-sticky-note/{id}")
	public String editStickyNote(@PathVariable(name= "id") Long id, Model model) {
		StickyNoteDTO dto = this.stickyNoteservice.findById(id); 
		model.addAttribute("StickyNote", dto);
		return "edit-sticky-note";
	}
	
	@PostMapping("/save")
	public String addStickyNote(@ModelAttribute("dto")  AddStickyNoteDTO dto) {
		 this.stickyNoteservice.addStickyNote(dto);
		 return "redirect:/";
	}
	
	
	@PostMapping("/sticky-note/edit-sticky-note/update/{id}")
	public String updateStickyNote(@PathVariable(name= "id") Long id,@ModelAttribute("dto")  UpdateStickyNoteDTO dto) {
		 this.stickyNoteservice.update(dto , id);
		 return "updated-successfully";
		 
	}


}
