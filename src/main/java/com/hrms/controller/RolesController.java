/**
 * 
 */
package com.hrms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.exception.CustomException;
import com.hrms.services.RolesService;

/**
 * @author Dell
 *
 */
@RestController
@RequestMapping("/hrms/api")
public class RolesController {
	@Autowired
	private RolesService rolesService ;
	
	@GetMapping("/roles")
	public ResponseEntity<Object> getAllRoles() {
		System.out.println("Get All Roles");
		Map<String, Object> roles = rolesService.getAllRoles();
		if (roles == null) {
			String message = "no roles Found";
			String details = "Please check that data exists";
			System.out.println(message + "," + details);
			return new ResponseEntity<Object>(new CustomException(message, details), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(roles, HttpStatus.OK);
	}
}
