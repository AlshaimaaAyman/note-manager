package com.noteManagerSystem.stickynotes.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.noteManagerSystem.stickynotes.model.dto.AddNoteDTO;
import com.noteManagerSystem.stickynotes.model.dto.NoteDTO;
import com.noteManagerSystem.stickynotes.model.entity.NoteEntity;
import com.noteManagerSystem.stickynotes.model.entity.StickyNoteEntity;
import com.noteManagerSystem.stickynotes.model.mapper.NoteMapper;
import com.noteManagerSystem.stickynotes.repository.NoteRepo;
import com.noteManagerSystem.stickynotes.service.NoteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoteServiceImpl implements NoteService{
	
	private final NoteMapper noteMapper;
	private final NoteRepo noteRepo;
	

	@Override
	public NoteDTO addNote(AddNoteDTO dto, Long stickyNoteId) {
		NoteEntity entity =  this.noteMapper.toEntity(dto);
		entity.setStickyNoteId(stickyNoteId);

		NoteEntity savedEntity =  this.noteRepo.save(entity);
		NoteDTO savedDto =  this.noteMapper.toDto(savedEntity);
		
		return savedDto;
		
	}


	@Override
	public List<NoteDTO> getAllNotesByStickyNoteId(Long stickyNoteId) {
		
       List<NoteEntity> notes=  this.noteRepo.findByStickyNoteIdOrderByIdDesc(stickyNoteId);
       List<NoteDTO> dtos = this.noteMapper.toDtos(notes);
		return dtos;
	}


	@Override
	public void deleteById(Long noteId) {
		this.noteRepo.deleteById(noteId);		
	}
	
	@Override
	public List<NoteDTO> myNotes() {
		
		List<NoteEntity> entities = this.noteRepo.findAll();
		List<NoteDTO> dtos = this.noteMapper.toDtos(entities);
		return dtos;
		
	}

}
