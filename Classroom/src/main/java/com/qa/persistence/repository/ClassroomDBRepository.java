package com.qa.persistence.repository;

import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import static javax.transaction.Transactional.TxType.REQUIRED;

@Transactional(SUPPORTS)
public class ClassroomDBRepository implements ClassroomRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util; 
	
	@Override
	@Transactional(REQUIRED)
	public String createClassroom(String trainerName) {
		Classroom aClassroom = util.getObjectForJSON(trainerName, Classroom.class);
		manager.persist(aClassroom);
		return "{\"message\": \"This classroom has been sucessfully added\"}"; 
	}

	@Override
	public String getAllClassrooms() {
		Query query = manager.createQuery("SELECT c FROM Classroom c");
		return util.getJSONForObject((Collection<Classroom>) query.getResultList());
	}

	@Override
	public String getAClassroom(int classroomId) {
		return util.getJSONForObject(manager.find(Classroom.class, classroomId));
	}

	@Override
	@Transactional(REQUIRED)
	public String updateClassroom(String trainerName, int classroomId) {
		Classroom aClassroom = util.getObjectForJSON(trainerName, Classroom.class);
		if(manager.find(Classroom.class, classroomId) != null)
		{
			manager.remove(manager.find(Classroom.class, trainerName));
			manager.merge(aClassroom);
			return "{\"message\": \"Classrom has been sucessfully been updated\"}";
		}
		return "{\"message\": \"Classroom account does not exist\"}";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String deleteClassroom(int classroomId) {
		if(manager.contains(manager.find(Classroom.class, classroomId)))
		{
			manager.remove(manager.find(Classroom.class, classroomId));
		}
		return "{\"message\": \"Classroom has been sucessfully been deleted\"}";
	}

	@Override
	public int cycleClassrooms(String trainerName) {
		Query query = manager.createQuery("SELECT c FROM Classroom c");
		return ((Collection<Classroom>) query.getResultList()).stream().filter(x -> x.getTrainerName().equals(trainerName)).collect(Collectors.toList()).size();
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
