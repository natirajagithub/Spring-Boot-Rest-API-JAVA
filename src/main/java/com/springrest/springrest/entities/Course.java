package com.springrest.springrest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Course {
	
	
	@Id
	private long id;
	private String firstName;
	private String lastName;
	private String title;
	private String description;
	

	
}
