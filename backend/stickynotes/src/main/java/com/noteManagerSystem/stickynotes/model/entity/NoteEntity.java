package com.noteManagerSystem.stickynotes.model.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.noteManagerSystem.stickynotes.model.enums.StickyNoteStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="notes")
@Entity
	
	
public class NoteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="note-id")
	private Long id;

	@Column(name="note")
	private String note;
	
//    @ManyToOne
//	@JoinColumn(name="sticky-note-id", insertable = false, updatable = false)
	@Column(name="sticky-note-id")
	private Long stickyNoteId;
	
	@Column(name="created_at")
	@CreationTimestamp
	private  LocalDateTime createdAt;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	private  LocalDateTime updatedAt;
	
	// @Column(name="deleted_at")
	// private  LocalDateTime deletedAt;
	


}
