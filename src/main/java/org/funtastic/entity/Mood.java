package org.funtastic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="mood")
public class Mood extends AbstractEntity{

	@Column(name="description",nullable=false)
	@NotNull
	private String description;

	public Mood() {
		super();
	}

	public Mood(String description) {
		super();
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
