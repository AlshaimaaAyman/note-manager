package com.noteManagerSystem.stickynotes.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.noteManagerSystem.stickynotes.model.enums.StickyNoteStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="sticky-note")
@Entity
public class StickyNoteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sticky-note-id")
	private Long id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="name")
	private String name;
	
	@Column(name="color")
	private String color;
	
	@Column(name="created_at")
	@CreationTimestamp
	private  LocalDateTime createdAt;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	private  LocalDateTime updatedAt;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private  StickyNoteStatus status;
	
//	@JsonManagedReference
//    @OneToMany(mappedBy="stickyNoteId")
//	private List<NoteEntity> notes;
			

}
