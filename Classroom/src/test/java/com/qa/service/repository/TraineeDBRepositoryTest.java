package com.qa.service.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TraineeDBRepositoryTest {
	
	@InjectMocks
	private TraineeDBRepository repo;
	
	@Mock
	private EntityManager manager;
	
	@Mock
	private Query query;
	
	private JSONUtil util;
	
	private static final String MOCK_DATA_ARRAY = "[{\"traineeName\":\"Joe Bloggs\",\"classroomId\":\"1\"}]";
	private static final String MOCK_DATA_ARRAY2 = "[{\"traineeId\":1,\"traineeName\":\"Joe Bloggs\"}]";   

	private static final String MOCK_OBJECT = "{\"traineeName\":\"Joe Bloggs\",\"classroomId\":\"1\"}";
	private static final String MOCK_OBJECT2 = "{\"traineeName\":\"Joe Bloggs\"}";
	
	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}
	
	@Test
	public void testCreateTrainee() {
		String reply = repo.createTrainee(MOCK_OBJECT2);
		assertEquals(reply, "{\"message\": \"Trainee has been sucessfully added\"}");
	}
	
	@Test
	public void testGetAllTrainees() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Trainee> trainees = new ArrayList<Trainee>();
		
		Trainee t1 = new Trainee("Joe Bloggs");
		t1.setTraineeId(1);
		trainees.add(t1);
		Mockito.when(query.getResultList()).thenReturn(trainees);
		System.out.println(repo.getAllTrainees());
		assertEquals(MOCK_DATA_ARRAY2, repo.getAllTrainees());
	}
	
//	@Test
//	public void tesGetATrainer()
//	{
//		
//	}
	
//	@Test
//	public void testUpdateTrainee()
//	{
//		
//	}
	
	@Test
	public void testDeleteTrainee()
	{
		String reply = repo.deleteTrainee(1);
		assertEquals(reply, "{\"message\": \"Trainee has been sucessfully been deleted\"}");
	}
	
//	@Test 
//	public void testCyleTrainees()
//	{
//		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
//		List<Trainee> trainees = new ArrayList<Trainee>();
//		trainees.add(new Trainee("Joe Bloggs"));
//		Mockito.when(query.getResultList()).thenReturn(trainees);
//		
//		assertEquals(1, repo.cycleTrainees("Joe"));
//	}

}
