package com.simpleapp.api.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Todo {

	 @Id
	 @EqualsAndHashCode.Include
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 Long id;
	 
	 @Column
	 private String description;
	 
	 @Column
	 private Boolean done;
	 
	 @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	 @CreationTimestamp
	 @Column
	 private LocalDateTime createdDate;
	 
	 @Column
	 private LocalDateTime doneDate;
}
