package com.projetCrud.crud.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetCrud.crud.model.Employee;
import com.projetCrud.crud.repository.EmployeeRepository;
import com.projetCrud.crud.service.EmployeeService;

@RestController
@RequestMapping("/crud")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService; //injection
	
	@GetMapping("/GetEmployees")
	public Iterable<Employee> getEmployee(){
		
		return employeeService.getAllEmployee();
		
	}
	
	@PostMapping("/PostEmployees")
	public Employee createEmployee(@Validated @RequestBody Employee employee) {
		
		return employeeService.saveEmployee(employee);
	}
	
	@DeleteMapping("/DeleteEmployees/{id}")
	public void supprimerEmployee(@PathVariable Integer id) {
		 employeeService.deleteEmployee(id);

	}
	@GetMapping("/getOneEmployees/{id}")
	public Optional<Employee> oneEmployee(@PathVariable Integer id) {
		return employeeService.getOneEmployee(id);

	}
	
	
	@PutMapping("/updateEmployees/{id}")
	public Employee updateEmployee(@RequestBody Employee employee,@PathVariable Integer id) {
		return employeeService.updateEmployee(employee,id);

	}
//	private EmployeeRepository employeeRepository;
	
//	@GetMapping("/employees")
//	public List<Employee> getAllEmployees(){
//		return employeeRepository.findAll();
//	}
//	@PostMapping("/employees")
//	public Employee ctreateEmployee(@Validated @RequestBody Employee employee){
//		return employeeRepository.save(employee);
//	}
	

}
