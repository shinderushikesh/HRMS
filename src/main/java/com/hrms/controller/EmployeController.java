package com.hrms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.exception.CustomException;
import com.hrms.services.EmployeeService;

@RestController
@RequestMapping("/hrms/api")
public class EmployeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<Object> getAllEmployee(@RequestParam(defaultValue = "1") Integer pageNo,
			@RequestParam(defaultValue = "5") Integer pageSize) {
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

}
