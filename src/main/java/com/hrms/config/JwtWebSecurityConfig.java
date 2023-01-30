/**
 * 
 */
package com.hrms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



/**
 * @authorMahesh Bhakare
 * @version 1.8
 * @date 
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JwtWebSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private CustomUserDetailService customUserDetailService ;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter ;
	
	  @Bean
	    public PasswordEncoder passwordEncoder()
	    {
	    	return NoOpPasswordEncoder.getInstance() ;
	    }
	  
	  @Bean
	    public BCryptPasswordEncoder bCryptPasswordEncoder()
	    {
	    	return new BCryptPasswordEncoder();
	    }
	  
	  @Bean
	  public AuthenticationManager authenticationManagerBean () throws Exception
	  {
		  return super.authenticationManagerBean();
	  }

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(customUserDetailService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable().cors().disable().authorizeRequests()
		.antMatchers("/hrms/api/token").permitAll().
		anyRequest().authenticated()
		.and()//.oauth2Login() ;
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) ;
		
//		http.antMatcher("/**").authorizeRequests()
//		.antMatchers("/welcome2").permitAll()
//		.anyRequest().authenticated()
//		.and()
//		.oauth2Login();
	//	http.authorizeRequests().antMatchers("/ui-assist/v1/commonfeedbackservice/**").fullyAuthenticated().and().httpBasic();
		}
	
	
}
