package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.ClassroomDBRepository;
import com.qa.util.JSONUtil;

public class ClassroomServiceImpl implements ClassroomService{

	@Inject 
	ClassroomDBRepository repo;
	
	@Inject
	JSONUtil util;
	
	@Override
	public String createClassroom(String trainerName) {
		return repo.createClassroom(trainerName);
	}

	@Override
	public String getAllClassrooms() {
		return repo.getAllClassrooms();
	}

	@Override
	public String getAClassroom(int classroomId) {
		return repo.getAClassroom(classroomId);
	}

	@Override
	public String updateClassroom(String trainerName, int classroomId) {
		return repo.updateClassroom(trainerName, classroomId);
	}

	@Override
	public String deleteClassroom(int classroomId) {
		return repo.deleteClassroom(classroomId);
	}

	@Override
	public int cycleClassrooms(String trainerName) {
		return repo.cycleClassrooms(trainerName);
	}

	public void setRepo(ClassroomDBRepository repo) {
		this.repo = repo;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
