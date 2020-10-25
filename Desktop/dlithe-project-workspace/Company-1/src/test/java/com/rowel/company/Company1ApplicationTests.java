package com.rowel.company;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Vector;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@RunWith(SpringRunner.class)
class Company1ApplicationTests {

	@MockBean
	EmpRepo repo;
	@Autowired
	EmpService serv;
	
	@Test
	public void testAdd()
	{
		Employee emp = new Employee(1, "Rowel Steve", 11223311, "Brahamvar, Udupi", 4, 23000.0, "M", null);
		Employee emp2 = null;
		when(repo.save(emp)).thenReturn(emp);
		assertEquals(emp, serv.newadd(emp));
		assertNotNull(serv.newadd(emp));
		emp2 = new Employee(10, "Powel", 222111233, "Bangalore", 5, 32000.0, "M", 33222111);
		assertFalse(serv.newadd(emp).getEmpid()==10);
	}
	
	@Test
	public void testIterate()
	{
		List<Employee> group = new Vector<Employee>();
		Employee emp1 = new Employee(11, "Ben", 111222999, "Delhi", 2, 19000.0, "M", 33222111);
		Employee emp2 = new Employee(12, "Tim", 111331122, "Hyderabad", 2, 21000.0, "M", 111333222);
		Employee emp3 = new Employee(13, "Emily", 111333222, "Bangalore", 2, 15000.0, "F", null);
		group.add(emp1);group.add(emp2);group.add(emp3);
	}
	
	
	
	@Test
	public void testDelete()
	{
		Employee emp1 = new Employee(11, "Ben", 111222999, "Delhi", 2, 19000.0, "M", 33222111);
		Employee emp2 = new Employee(12, "Tim", 111331122, "Hyderabad", 2, 21000.0, "M", 111333222);
		assertSame(emp1.getEname(), serv.remove(emp1));
	}

}
