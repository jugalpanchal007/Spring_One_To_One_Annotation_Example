package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;





@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	@Autowired
	public EmployeeRepository employeeRepository;
	

	//get empoyee detail
	@GetMapping(value = {"","/"})
	
	public List<Employee> getAllEmployees(){
		return this.employeeRepository.findAll();
	}
	
	
	//get employee detail by id
	 @GetMapping("/{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
	        throws ResourceNotFoundException {
	        Employee employee = employeeRepository.findById(employeeId)
	        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	        return ResponseEntity.ok().body(employee);
	    }
	
	//save empoyee(post mapping concept)
	 @PostMapping("/")
	public Employee creatEmployee(@RequestBody Employee employee)
	{
		return this.employeeRepository.save(employee); 
	}
	
	//update employee by id
	 @PutMapping("/{id}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
	         @Validated @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
	         Employee employee = employeeRepository.findById(employeeId)
	        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

	        employee.setName(employeeDetails.getName());
		        employee.setAddress(employeeDetails.getAddress());
		      
//		        final Employee updatedEmployee = employeeRepository.save(employee);
		        return ResponseEntity.ok(this.employeeRepository.save(employee));
	         
	         
	         //original code
	      /*  employee.setEmail(employeeDetails.getEmail());
	        employee.setFirstName(employeeDetails.getFirstName());
	        employee.setLastName(employeeDetails.getLastName());
//	        final Employee updatedEmployee = employeeRepository.save(employee);
	        return ResponseEntity.ok(this.employeeRepository.save(employee));*/
	    }
	//delete empoyee by id
	 @DeleteMapping("/{id}")
	    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
	        throws ResourceNotFoundException {
	        Employee employee = employeeRepository.findById(employeeId)
	        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

	       employeeRepository.delete(employee);
	       Map<String, Boolean> response = new HashMap<>();
	       response.put("deleted", Boolean.TRUE);
	       return response;
	    }
}
   