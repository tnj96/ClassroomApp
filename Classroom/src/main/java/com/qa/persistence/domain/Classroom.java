package com.qa.persistence.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Classroom")
@Table(name = "classroom")
public class Classroom {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int classroomId;
	
	private String trainerName;
	
	@OneToMany(mappedBy="classroom")
	@JoinColumn(name = "classromId")
	private Collection<Trainee> trainees;

	public Classroom() {
	
	}

	public Classroom(String trainerName, Collection<Trainee> trainees) {
		this.trainerName = trainerName;
		this.trainees = trainees;
	}

	public int getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(int classroomId) {
		this.classroomId = classroomId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public Collection<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(Collection<Trainee> trainees) {
		this.trainees = trainees;
	}
	

}
