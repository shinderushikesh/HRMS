/**
 * 
 */
package com.hrms.config;

import java.net.PasswordAuthentication;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hrms.entity.Users;
import com.hrms.repository.UserRepository;
import com.hrms.services.JwtService;

/**
 * @author Mahesh Bhakare
 * @version 1.8
 * @date 
 */
@Service
public class CustomUserDetailService implements UserDetailsService 
{
	@Autowired
	private UserRepository userRepository ;
	
	@Override
	public UserDetails loadUserByUsername(String username ) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Users  user = userRepository.findByUsername(username) ;
		
		if(username.equals(user.getUsername()) )
		{
			return new User (user.getUsername(), user.getPassword(), new ArrayList<>() ) ;
		}
		else
		{
			throw new UsernameNotFoundException("User not found");
		}
		
		
	}

}
