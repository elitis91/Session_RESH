package com.covea.simplecrudapi.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Size(min=2, max=120)
	@Column(name = "title")
	private String title;
	
	@NotBlank
	@Size(min=2, max=255)
	@Column(name = "description")
	private String description;
	
	@Column(name = "publish")
	private boolean publish;
	
	public Book() {
	}
	
	public Book(Long id, String title, String description, boolean publish) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.publish = publish;
	}
	
	public Book(String title, String description, boolean publish) {
		this.title = title;
		this.description = description;
		this.publish = publish;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPublish() {
		return publish;
	}

	public void setPublish(boolean publish) {
		this.publish = publish;
	}

}
