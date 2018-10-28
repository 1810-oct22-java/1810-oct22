package question1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import question2.FibonacciTest;
import question3.ReverseStringTest;
import question4.NFactorialTest;
import question5.StringIndexTest;
import question6.EvenOrOddTest;
import question7.CompareEmployeesTest;
import question8.PalindromesTest;
import question9.PrimeNumbersTest;
import question10.MinimumTest;
import question11.AccessDifferentPackageTest;
import question12.EvenNumbersTest;
import question15.ImplementingClassTest;


@RunWith(Suite.class)
@SuiteClasses({BubbleSortTest.class,FibonacciTest.class,ReverseStringTest.class, NFactorialTest.class, StringIndexTest.class,EvenOrOddTest.class,
	CompareEmployeesTest.class,PalindromesTest.class,PrimeNumbersTest.class,MinimumTest.class, AccessDifferentPackageTest.class,EvenNumbersTest.class,ImplementingClassTest.class})
public class AllTests {

}
