package question7;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;


public class CompareEmployeesTest {

	@Test
	public void test() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		ArrayList<Employee> testEmps = new ArrayList<Employee>();
		employees.add(new Employee("Ian Barney", "Training", 22));
		employees.add(new Employee("Genesis Bonds", "Teaching", 50));
		employees.add(new Employee("Ian Barney", "Sales", 30));
		employees.add(new Employee("Ian Barney", "Training", 21));
		testEmps.add(new Employee("Genesis Bonds", "Teaching", 50));
		testEmps.add(new Employee("Ian Barney", "Sales", 30));
		testEmps.add(new Employee("Ian Barney", "Training", 21));
		testEmps.add(new Employee("Ian Barney", "Training", 22));
		Collections.sort(employees, new SortEmployee());
		
		for (int i = 0; i < employees.size(); i++) {
			assertTrue(employees.get(i).toString().equals(testEmps.get(i).toString()));
		}
	}

}
