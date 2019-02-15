package com.qa.persistence.repository;

public interface ClassroomRepository {
	
	String createClassroom(String trainerName);
	
	String getAllClassrooms();
	
	String getAClassroom(int classroomId);
	
	String updateClassroom(String trainerName, int classroomId);
	
	String deleteClassroom(int classroomId);
	
	int cycleClassrooms(String trainerName);

}
