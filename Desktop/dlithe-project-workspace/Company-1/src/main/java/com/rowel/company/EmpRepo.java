package com.rowel.company;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer>
{
	@Query("select em from Employee em where em.salary>=?1")
	public List<Employee> readBySalary(double salary);
	@Query("select em from Employee em where em.dno=?1")
	public List<Employee> readByDno(int dno);
	@Query("select em from Employee em where em.sex=?1")
	public List<Employee> readBySex(String val);
	@Query("select em from Employee em where em.superssn=?1")
	public List<Employee> readBySuperssn(int ssn);
}
