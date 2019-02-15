package com.qa.service.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Trainee;
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
	

//	private static final String MOCK_OBJECT2_TRAINEE = "{\"traineeName\":\"Joe Bloggs\"}";
	
	private static final Collection<Trainee> MOCK_TRAINEES = new ArrayList<Trainee>();
	private static final String MOCK_DATA_ARRAY = "[{\"trainerName\" : \"John Gordon\", \"trainees\" : \"  \"}]";

	private static final String MOCK_OBJECT = "{\"trainerName\" : \"John Gordon\", \"trainees\" : \"  \"}";
	@Before
	public void setup() {
//		MOCK_TRAINEES.add(arg0)
		repo.setManager(manager);
		util = new JSONUtil(); 
		repo.setUtil(util);
	}
	
	@Test
	public void createClassroomTest()
	{
		String reply = repo.createClassroom(MOCK_OBJECT);
		assertEquals(reply,"{\"message\": \"This classroom has been sucessfully added\"}");
	}
}
