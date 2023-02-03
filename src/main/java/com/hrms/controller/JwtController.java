/**
 * 
 */
package com.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.config.CustomUserDetailService;
import com.hrms.config.JwtHelper;
import com.hrms.dto.JwtRequest;
import com.hrms.dto.JwtResponse;
import com.hrms.entity.Users;
import com.hrms.entity.Roles;
import com.hrms.repository.UserRepository;

/**
 * @author Mahesh Bhakare
 * @version 1.8
 * @date
 *
 */
@RestController
@RequestMapping("/hrms/api")
public class JwtController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Autowired
	private JwtHelper jwtHelper;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) {
		System.out.println("JwtToken" + jwtRequest);
		try {
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (Exception e) {
			System.out.println(e);
		}

		String reqUsername = jwtRequest.getUsername();
		String reqPassword = jwtRequest.getPassword();
		String reqRole = jwtRequest.getRole();

		Users user = userRepository.findByUsername(reqUsername);

		String dbUsername = user.getUsername();
		String dbPassword = user.getPassword();
		Roles dbRole = user.getRoles() ;

		// Boolean isMatch = passwordEncoder.matches(reqPassword, dbPassword);

		if (reqUsername.equals(dbUsername) && reqPassword.equals(dbPassword) && (dbRole.getRole()).equals(reqRole)) {
			// generate token
			UserDetails userDetails = this.customUserDetailService.loadUserByUsername(jwtRequest.getUsername());
			String token = this.jwtHelper.generateToken(userDetails);
			System.out.println("Token:" + token);
			return ResponseEntity.ok(new JwtResponse(token));
		}
		else {
			return ResponseEntity.ok("username and password not found");
		}

	}
}
