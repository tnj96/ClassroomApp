package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.TraineeRepository;
import com.qa.util.JSONUtil;

public class TraineeServiceImpl implements TraineeService{

	@Inject
	TraineeRepository repo;
	
	@Inject 
	JSONUtil util;
	
	@Override
	public String createTrainee(String traineeName) {
		return repo.createTrainee(traineeName);
	}

	@Override
	public String getAllTrainees() {
		return repo.getAllTrainees();
	}

	@Override
	public String getATrainee(int traineeId) {
		return repo.getATrainee(traineeId);
	}

	@Override
	public String updateTrainee(String traineeName, int traineeId) {
		return repo.updateTrainee(traineeName, traineeId);
	}

	@Override
	public String deleteTrainee(int traineeId) {
		return repo.deleteTrainee(traineeId);
	}

	@Override
	public int cycleTrainees(String traineeName) {
		return repo.cycleTrainees(traineeName);
	}

	public void setRepo(TraineeRepository repo) {
		this.repo = repo;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
