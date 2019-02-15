package com.qa.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.qa.service.repository.ClassroomDBRepositoryTest;


@RunWith(Suite.class)

@Suite.SuiteClasses({ClassroomDBRepositoryTest.class})
public class TestSuite {
}