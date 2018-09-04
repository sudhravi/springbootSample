package com.bootexample.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	
	Employee findByName(String s);
	
	List<Employee> findByDepartment(Department dept);
}
