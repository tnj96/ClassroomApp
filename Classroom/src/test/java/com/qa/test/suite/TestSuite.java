package com.qa.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.qa.service.repository.TraineeDBRepositoryTest;
import com.qa.service.repository.TraineeServiceImplTest;


@RunWith(Suite.class)

@Suite.SuiteClasses({TraineeDBRepositoryTest.class, TraineeServiceImplTest.class})
public class TestSuite {
}