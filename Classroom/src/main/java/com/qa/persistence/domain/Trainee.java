package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Trainee")
@Table(name = "trainee")
public class Trainee {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int traineeId;
	
	private String traineeName;

	@ManyToOne
	@JoinColumn(name="classroomId") 
	private Classroom classroomid;
	
	public Trainee() {
		
	}

	public Trainee(String traineeName) {
		this.traineeName = traineeName;
//		this.classroomid = classroom;
	} 

	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public Classroom getClassroom() {
		return classroomid;
	}

	public void setClassroomId(Classroom classroom) {
		this.classroomid = classroom;
	}
	
}
