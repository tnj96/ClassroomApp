package com.qa.service.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.TraineeServiceImpl;
import com.qa.persistence.repository.TraineeDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TraineeServiceImplTest 
{
	@InjectMocks
	private TraineeServiceImpl service;
	
	@Mock
	private TraineeDBRepository repo;
	
	private JSONUtil util;
	
	private static final String MOCK_DATA_ARRAY = "[{\"traineeName\":\"Joe Bloggs\",\"classroomId\":\"1\"}]";
	private static final String MOCK_DATA_ARRAY2 = "[{\"traineeId\":1,\"traineeName\":\"Joe Bloggs\"}]";   

	private static final String MOCK_OBJECT = "{\"traineeName\":\"Joe Bloggs\",\"classroomId\":\"1\"}";
	private static final String MOCK_OBJECT2 = "{\"traineeName\":\"Joe Bloggs\"}";
	
	@Before
	public void setup()
	{
		service.setRepo(repo);
		util = new JSONUtil();
		service.setUtil(util);
	}
	
	@Test
	public void testCreateTrainee()
	{
		Mockito.when(repo.createTrainee(MOCK_OBJECT2)).thenReturn(MOCK_OBJECT2);
		assertEquals(MOCK_OBJECT2, service.createTrainee(MOCK_OBJECT2));
		Mockito.verify(repo).createTrainee(MOCK_OBJECT2);	
	}
	
//	@Test 
//	public void getAllTrainees() {
//		Mockito.verify(repo).getAllTrainees();
//	}
//
//	public void getATrainee(int traineeId) {
//		Mockito.verify(repo).getATrainee();
//	}
//
//	public void updateTrainee() {
//		Mockito.verify(repo).updateTrainee();
//	}
//
//	public void deleteTrainee() {
//		Mockito.verify(repo).deleteTrainee();
//	}
//
//	public void cycleTrainees() {
//		Mockito.verify(repo).cycleTrainees();
//	}

}
