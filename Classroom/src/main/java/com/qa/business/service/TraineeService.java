package com.qa.business.service;

public interface TraineeService {
	
	String createTrainee(String traineeName);
	
	String getAllTrainees();
	
	String getATrainee(int traineeId);
	
	String updateTrainee(String traineeName, int traineeId);
	
	String deleteTrainee(int traineeId);
	
	int cycleTrainees(String traineeName);

}
