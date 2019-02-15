package com.qa.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.qa.service.repository.ClassroomDBRepositoryTest;
import com.qa.service.repository.TraineeDBReposityTest;
import com.qa.service.repository.TraineeServiceImplTest;


@RunWith(Suite.class)

@Suite.SuiteClasses({ClassroomDBRepositoryTest.class, TraineeDBReposityTest.class, TraineeServiceImplTest.class})
public class TestSuite {
}