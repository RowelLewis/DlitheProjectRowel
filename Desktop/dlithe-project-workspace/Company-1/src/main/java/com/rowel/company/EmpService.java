package com.rowel.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmpService {
	
	@Autowired
	private EmpRepo repo;
	
	public Employee newadd(Employee emp)
	{
		return repo.save(emp);
	}
	
	public Employee single(int id)
	{
		return repo.findById(id).orElse(new Employee());
	}
	
	public List<Employee> every()
	{
		return repo.findAll();
	}
	
	public String remove(Employee emp)
	{
		String model=emp.getEname();
		repo.delete(emp);
		return model;
	}
	public Employee alter(Employee emp)
	{
		return repo.save(emp);
	}
	
	public List<Employee> getBySalary(double d)
	{
		return repo.readBySalary(d);
	}
	public List<Employee> getBySex(String val)
	{
		return repo.readBySex(val);
	}
	public List<Employee> getByDno(int dno)
	{
		return repo.readByDno(dno);
	}
	public List<Employee> getBySuperssn(int superssn)
	{
		return repo.readBySuperssn(superssn);
	}
	
}
