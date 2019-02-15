package com.qa.service.repository;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.repository.ClassroomDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ClassroomDBRepositoryTest {

	@InjectMocks
	private ClassroomDBRepository repo;
	
	@Mock
	private EntityManager manager;
	
	@Mock
	private Query query;
	
	private JSONUtil util;
	
//	private static final String MOCK_DATA_ARRAY_TRAINEE = "[{\"traineeName\":\"Joe Bloggs\",\"classroomId\":\"1\"}]";
//	private static final String MOCK_DATA_ARRAY2_TRAINEE = "[{\"traineeId\":1,\"traineeName\":\"Joe Bloggs\"}]";   
//	private static final String MOCK_OBJECT_TRAINEE = "{\"traineeName\":\"Joe Bloggs\",\"classroomId\":\"1\"}";
//	private static final String MOCK_OBJECT2_TRAINEE = "{\"traineeName\":\"Joe Bloggs\"}";
	
	private static final String MOCK_DATA_ARRAY = "[{\"trainerName\" : \"John Gordon\", \"trainees\" : \"  \"}]";

	private static final String MOCK_OBJECT = "{\"trainerName\" : \"John Gordon\", \"trainees\" : \"  \"}";
	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil(); 
		repo.setUtil(util);
	}
	
//	@Test
//	public void createClassroomTest()
//	{
//		String reply = repo.createClassroom(MOCK_OBJECT);
//		assertEquals(reply,"{\"message\": \"This classroom has been sucessfully added\"}");
//	}
}
