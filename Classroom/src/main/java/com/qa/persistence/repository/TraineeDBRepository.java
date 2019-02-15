package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class TraineeDBRepository implements TraineeRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util; 
	
	@Override
	@Transactional(REQUIRED)
	public String createTrainee(String traineeName) {
		Trainee aTrainee = util.getObjectForJSON(traineeName, Trainee.class);
		manager.persist(aTrainee);
		return "{\"message\": \"Trainee has been sucessfully added\"}"; 
	}

	@Override
	public String getAllTrainees() {
		Query query = manager.createQuery("SELECT t FROM Trainee t");
		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(trainees);
	}

	@Override
	public String getATrainee(int traineeId) {
		return util.getJSONForObject(manager.find(Trainee.class, traineeId)); 
	}

	@Override
	@Transactional(REQUIRED)
	public String updateTrainee(String traineeName, int traineeId) {
		Trainee aTrainee = util.getObjectForJSON(traineeName, Trainee.class);
		if(manager.find(Trainee.class, traineeId) != null)
		{
			manager.remove(manager.find(Trainee.class, traineeId));
			manager.merge(aTrainee);
			return "{\"message\": \"Trainee has been sucessfully been updated\"}";
		}
		return "{\"message\": \"Trainee account does not exist\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteTrainee(int traineeId) {
		if(manager.contains(manager.find(Trainee.class, traineeId)))
		{
			manager.remove(manager.find(Trainee.class, traineeId));
		}
		return "{\"message\": \"Trainee has been sucessfully been deleted\"}";
	}

	@Override
	public int cycleTrainees(String traineeName) {
		Query query = manager.createQuery("SELECT t FROM Trainee t");
		return ((Collection<Trainee>) query.getResultList()).stream().filter(x -> x.getTraineeName().equals(traineeName)).collect(Collectors.toList()).size();
	}

	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
