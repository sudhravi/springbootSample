package com.bootexample.demo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class EmployeeResource {
	
@Autowired
private EmployeeRepository employeeRepository;

@GetMapping("/employee")
public List<Employee> retrieveAll(){
	return employeeRepository.findAll();
}

@GetMapping("/employee/{id}")
public Employee retrieveEmployee(@PathVariable long id) {
	Optional<Employee> employee = employeeRepository.findById(id);

	if (!employee.isPresent())
		throw new EmployeeNotFoundException("id-" + id);

	return employee.get();
}


@PostMapping("/employee")
public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
	Employee savedEmployee = employeeRepository.save(employee);

	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(savedEmployee.getId()).toUri();

	return ResponseEntity.created(location).build();

}

@DeleteMapping("/employee/{id}")
public void deleteStudent(@PathVariable long id) {
    employeeRepository.deleteById(id);
}

@PutMapping("/employee/{id}")
public Employee updateStudent(@RequestBody Employee employee, @PathVariable long id) {

	Optional<Employee> employeeOptional = employeeRepository.findById(id);

	if (!employeeOptional.isPresent())
		return null;

	employee.setId(id);

	return employeeRepository.save(employee);
}

}
