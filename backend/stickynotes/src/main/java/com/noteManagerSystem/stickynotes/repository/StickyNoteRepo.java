package com.noteManagerSystem.stickynotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noteManagerSystem.stickynotes.model.entity.StickyNoteEntity;
import com.noteManagerSystem.stickynotes.model.enums.StickyNoteStatus;

public interface StickyNoteRepo extends JpaRepository<StickyNoteEntity, Long>{
	
	List<StickyNoteEntity> findAllByStatus(StickyNoteStatus status);
	

}
