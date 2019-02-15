package com.qa.business.service;

public interface ClassroomService {
	
	String createClassroom(String trainerName);
	
	String getAllClassrooms();
	
	String getAClassroom(int classroomId);
	
	String updateClassroom(String trainerName, int classroomId);
	
	String deleteClassroom(int classroomId);
	
	int cycleClassrooms(String trainerName);

}
