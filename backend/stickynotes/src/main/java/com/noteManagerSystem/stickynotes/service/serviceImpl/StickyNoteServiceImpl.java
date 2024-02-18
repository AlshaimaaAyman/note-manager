package com.noteManagerSystem.stickynotes.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.noteManagerSystem.stickynotes.model.dto.AddStickyNoteDTO;
import com.noteManagerSystem.stickynotes.model.dto.NoteDTO;
import com.noteManagerSystem.stickynotes.model.dto.StickyNoteDTO;
import com.noteManagerSystem.stickynotes.model.dto.UpdateStickyNoteDTO;
import com.noteManagerSystem.stickynotes.model.entity.StickyNoteEntity;
import com.noteManagerSystem.stickynotes.model.enums.StickyNoteStatus;
import com.noteManagerSystem.stickynotes.model.mapper.StickyNoteMapper;
import com.noteManagerSystem.stickynotes.repository.StickyNoteRepo;
import com.noteManagerSystem.stickynotes.service.StickyNoteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StickyNoteServiceImpl implements StickyNoteService{

	private final StickyNoteRepo stickyNoteRepo;
	private final StickyNoteRepo NoteRepo;
	private final StickyNoteMapper mapper;
	
	@Override
	public AddStickyNoteDTO addStickyNote(AddStickyNoteDTO dto) {
		
		StickyNoteEntity entity = this.mapper.toEntity(dto);
		entity.setStatus(StickyNoteStatus.ACTIVE);
		//entity.setStatus(StickyNoteStatus.ENABLED);
		StickyNoteEntity savedEntity = this.stickyNoteRepo.save(entity);
		AddStickyNoteDTO addStickyNoteDTO = this.mapper.toAddDto(savedEntity);

		return addStickyNoteDTO;
	}

	@Override
	public List<StickyNoteDTO> allStickyNotes(StickyNoteStatus status) {
        
		List<StickyNoteEntity> entitis = this.stickyNoteRepo.findAllByStatus(status);
		List<StickyNoteDTO> dtos = mapper.toDtos(entitis);
		return dtos;
	}

	@Override
	public StickyNoteDTO findById(Long id) {
		
		Optional<StickyNoteEntity> entity	=  this.stickyNoteRepo.findById(id);
		return this.mapper.toDto(entity.get());
	}

	@Override
	public void update(UpdateStickyNoteDTO dto, Long id) {
	
		StickyNoteEntity entity = this.mapper.toEntity(dto);
		entity.setId(id);
		StickyNoteEntity savedEntity = this.stickyNoteRepo.save(entity);
	}



	 	
}
