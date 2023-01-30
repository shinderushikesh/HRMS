/**
 * 
 */
package com.hrms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hrms.config.CustomUserDetailService;
import com.hrms.config.JwtHelper;
import com.hrms.dto.JwtResponse;
import com.hrms.entity.Users;
import com.hrms.services.JwtService;

/**
 * @author Mahesh Bhakare
 * @version 1.8
 * @date 
 */
@RestController
@RequestMapping("/hrms/api")
@CrossOrigin(origins="http://localhost:3000")
public class JwtHome 
{
	@Autowired
	private JwtService jwtService ;
	
	@Autowired
	private JwtHelper jwtHelper ;
	
	@Autowired
	private AuthenticationManager authenticationManager ;
	
	@Autowired
	private CustomUserDetailService customUserDetailService ;
	
//	@GetMapping("/welcome")
//	public RedirectView welcome(HttpServletRequest request)
//	{
//		StringBuffer url= request.getRequestURL();
//		System.out.println("URL: "+url);
//		String uri ="https://accounts.google.com/o/oauth2/auth?approval_prompt=force&scope=openid+profile&client_id=368029334897-2fbahd99p3p5m9amh7v4t4gtpudhtns0.apps.googleusercontent.com&redirect_uri=http://localhost:8086/welcome&response_type=code&access_type=offline&state=sda";
//		String uri2 = "http://localhost:8086/welcome?state=sda&code=4%2F0AX4XfWiqZVXvhHdmRJTaCmuRtG4oK0UywOb1r2ErXCKigc492bprPUvJyIO4Vo66sk1QCw&scope=profile+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile&authuser=0&prompt=consent/";
//		String header = request.getContextPath() + uri ;
//		RedirectView redirectView = new RedirectView();
//		
//		int visit = 0;
//		
//		System.out.println("referer ==" + visit);
//		
//		
//	//	System.out.println("referer == "+request.getHeader("referer"));
//		if(visit == 0) {
//		
//		redirectView.setUrl( header);
//		System.out.println("req1== "+header);
//		visit =1 ;
//		System.out.println("visit: "+visit);
//		return redirectView ;
//		}
//		else 
//		{
//			String header1 = request.getContextPath() + uri2 ;
//			System.out.println("Header1: "+header1);
//			
//			redirectView.setUrl(header1);
//			System.out.println("request uri2: "+request.getRequestURL());
//			System.out.println("req2"+header1);
//			return redirectView ;
//		}
//		
//	}
	
	@GetMapping("/welcome")
	public String  welcome() {
		return "this is restricted page........!";
		
	}
	
	
	@PostMapping("/user")
	public Users createUser(@RequestBody Users users)
	{
		System.out.println("in createUser");
		return jwtService.saveUser(users) ;
	}
//	
//	public Jwt genrateToken(@RequestBody Jwt jwt)
//	{
//		System.out.println(jwt);
//		try 
//		{
//			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwt.getUsername(), jwt.getPassword()));
//
//		}
//		catch (Exception e) 
//		{
//			System.out.println(e);
//		}
//		
//		UserDetails userDetails = customUserDetailService.loadUserByUsername(jwt.getUsername()) ;
//		String token = this.jwtHelper.generateToken(userDetails) ;
//		System.out.println("JWT" + token);
//		return Jwt.ok(new JwtResponse(token));
//		
//	}
}
