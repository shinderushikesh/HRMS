package com.hrms.controller;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.entity.Employee;
import com.hrms.exception.CustomException;
import com.hrms.services.EmployeeService;

@RestController
@RequestMapping("/hrms/api")
public class EmployeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<Object> getAllEmployee(@RequestParam(defaultValue = "1") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		System.out.println("Get All Employee");
		Map<String, Object> emp = employeeService.getAllEmployees(pageNo, pageSize);
		if (emp == null) {
			String message = "no Employees Found";
			String details = "Please check that data exists";
			System.out.println(message + "," + details);
			return new ResponseEntity<Object>(new CustomException(message, details), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(emp, HttpStatus.OK);
	}

	// Add Employee
	@PostMapping("/add")
	public ResponseEntity<Object> addEmployee(@Validated @RequestBody Employee employee) {
		Employee Employe = null;
		try {
			Employe = employeeService.addEmployee(employee);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>(new CustomException(e.getLocalizedMessage(), e.getMessage()),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(Employe, HttpStatus.OK);

	}

	// get Employee by employee code
	@GetMapping("/employee-by-code/{emp_cd}")
	public ResponseEntity<Object> getByEmployeeCode(@PathVariable String emp_cd) {
		Employee Employe = employeeService.getByEmployeeCode(emp_cd);

		if (Employe == null) {
			String message = "Employee with Employee code " + emp_cd + " not found";
			String details = "Please check Employee code";
			return new ResponseEntity<Object>(new CustomException(message, details), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(Employe, HttpStatus.OK);
	}

	// soft delete Employee
	@Transactional
	@DeleteMapping("/employee/{emp_cd}")
	public ResponseEntity<Object> deleteEmployeeByCode(@PathVariable String emp_cd) {
		try {
			employeeService.deleteEmployee(emp_cd);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
	}

	@PutMapping("/employee/{emp_cd}")
	public ResponseEntity<Object> updateEmployeeByCode(@RequestBody Employee emp, @PathVariable String emp_cd) {
		try {
			return new ResponseEntity<>(employeeService.updateEmp(emp, emp_cd), 
			HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.NOT_FOUND);
		}

	}

}
