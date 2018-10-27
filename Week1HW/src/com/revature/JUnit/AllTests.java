package com.revature.JUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Question10Test.class, Question15Test.class, Question1Test.class, Question25Test.class,
		Question3Test.class, Question4Test.class, Question5Test.class, Question6Test.class, Question8Test.class })
public class AllTests {

}
