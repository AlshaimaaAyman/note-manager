package com.noteManagerSystem.stickynotes.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.noteManagerSystem.stickynotes.model.dto.AddStickyNoteDTO;
import com.noteManagerSystem.stickynotes.model.dto.StickyNoteDTO;
import com.noteManagerSystem.stickynotes.model.dto.UpdateStickyNoteDTO;
import com.noteManagerSystem.stickynotes.model.entity.StickyNoteEntity;

@Mapper(componentModel = "spring")
@Component
public interface  StickyNoteMapper {
	

	StickyNoteDTO toDto(StickyNoteEntity entity);
	StickyNoteEntity toEntity(StickyNoteDTO dto);
	
	
	List<StickyNoteDTO> toDtos(List<StickyNoteEntity> entities);
	List<StickyNoteEntity> toEntities(List<StickyNoteDTO> dtos);
	
	StickyNoteEntity toEntity(AddStickyNoteDTO dto);
	AddStickyNoteDTO toAddDto(StickyNoteEntity entity);
	
	StickyNoteEntity toEntity(UpdateStickyNoteDTO dto);
	
	  
	  
}
