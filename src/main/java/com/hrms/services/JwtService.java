/**
 * 
 */
package com.hrms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.entity.Users;
import com.hrms.repository.UserRepository;

/**
 * @author Mahesh Bhakare
 * @version 1.8
 * @date 
 *
 */
@Service
public class JwtService 
{
	@Autowired
	private UserRepository userRepository ;

	public Users saveUser(Users users) {
		// TODO Auto-generated method stub
		return userRepository.save(users);
	}
}
