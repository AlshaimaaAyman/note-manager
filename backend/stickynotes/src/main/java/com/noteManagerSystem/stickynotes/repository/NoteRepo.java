package com.noteManagerSystem.stickynotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.noteManagerSystem.stickynotes.model.entity.NoteEntity;

import jakarta.transaction.Transactional;

public interface NoteRepo extends JpaRepository<NoteEntity, Long> {
	
	List<NoteEntity> findByStickyNoteIdOrderByIdDesc(Long stickyNoteId);
	
	 
	 
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM NoteEntity n WHERE n.id = :noteId")
	void deleteById(Long noteId) ;

}
