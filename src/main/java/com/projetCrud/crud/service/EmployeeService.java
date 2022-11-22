package com.projetCrud.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetCrud.crud.repository.EmployeeRepository;

import com.projetCrud.crud.model.Employee;
import lombok.Data;

@Data
@Service
public class EmployeeService {
	
	@Autowired
		public EmployeeRepository employeeRepository;
	
	public Iterable<Employee> getAllEmployee(){
		
		return employeeRepository.findAll();
		
	}
	
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}
	
	public Optional<Employee> getOneEmployee(Integer id) {
		
		return employeeRepository.findById(id);
	}
	
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
    
    public Employee updateEmployee(Employee employee, Integer id) {
    	
     // Optional<Employee>  emplOptional = employeeRepository.findById(employee.getID());
      
    	 // return  employeeRepository.save(employee);
    	
    	Employee emp = employeeRepository.getById(id);
    	emp.setNom(employee.getNom());
    	emp.setPrenom(employee.getPrenom());
    	emp.setTelephone(employee.getTelephone());
    	    Employee empUpdated = employeeRepository.save(emp);
    	return empUpdated;

    	
    }

}
