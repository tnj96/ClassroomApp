package com.qa.persistence.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classroom {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int classroomId;
	
	private String trainerName;
	
	@OneToMany(mappedBy="classroom")
	private Collection<Trainee> trainees;
	

}
