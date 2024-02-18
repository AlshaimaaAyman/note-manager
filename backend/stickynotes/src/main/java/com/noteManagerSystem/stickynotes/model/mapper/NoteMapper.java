package com.noteManagerSystem.stickynotes.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.noteManagerSystem.stickynotes.model.dto.AddNoteDTO;
import com.noteManagerSystem.stickynotes.model.dto.NoteDTO;
import com.noteManagerSystem.stickynotes.model.entity.NoteEntity;

@Mapper(componentModel = "spring")
@Component
public interface NoteMapper {

	NoteEntity toEntity(NoteDTO dto);
	
	NoteDTO toDto(NoteEntity entity);
	
	List<NoteDTO> toDtos(List<NoteEntity> entities);

	NoteEntity toEntity(AddNoteDTO dto);
}
