/**
 * 
 */
package com.hrms.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hrms.entity.TokenLoginInfo;
import com.hrms.services.TokenLoginInfoService;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * @author Mahesh Bhakare
 * @version 1.8
 * @date 
 *
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter 
{
	@Autowired
	private CustomUserDetailService customUserDetailService ;
	
	@Autowired
	private JwtHelper jwtHelper ;
	
	@Autowired
	private TokenLoginInfoService tokenLoginInfoService ;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
		String requestTokenHeader =	request.getHeader("Authorization");
		String username = null ;
		String jwtToken = null ;
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7) ;
			try 
			{
				username = this.jwtHelper.getUsernameFromToken(jwtToken) ;
			} 
			catch (IllegalArgumentException  e) 
			{
				System.out.println("Unable to get JWT Token");
			}
			catch (ExpiredJwtException e ) {
				System.out.println("JWT Token has expired");
			}
		}
//		else {
//			
//		}
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null )
			{	
				UserDetails userDetails = this.customUserDetailService.loadUserByUsername(username) ;
//				TokenLoginInfo tokenLoginInfo = tokenLoginInfoService.findByUsername(username) ;
				
//				if (tokenLoginInfo != null && tokenLoginInfo.isFlag()) {
					
					if (jwtHelper.validateToken(jwtToken, userDetails)) {
						UsernamePasswordAuthenticationToken  usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken (userDetails, "null", userDetails.getAuthorities());
						usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)) ;
						SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
					}
					else {
						System.out.println("Token is not validate");
					}
//				}
			}
		
		filterChain.doFilter(request, response);	
	}
}


