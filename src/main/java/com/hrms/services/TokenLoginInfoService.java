/**
 * 
 */
package com.hrms.services;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.entity.TokenLoginInfo;
import com.hrms.repository.TokenLoginInfoRepository;

/**
 * @author Dell
 *
 */
@Service
@Transactional
public class TokenLoginInfoService {
	@Autowired
	private TokenLoginInfoRepository tokenLoginInfoRepository ;
	
	//public static final long JWT_TOKEN_VALIDITY = 15 * 60 * 1000 ;// 15 Minute 
	public static final long JWT_TOKEN_VALIDITY = 50 * 60 * 60; // 2 Minute
	
	public TokenLoginInfo saveUser(TokenLoginInfo tokenLoginInfo) {
		return tokenLoginInfoRepository.save(tokenLoginInfo);
	}

	public TokenLoginInfo findByUsername(String username) {
		return tokenLoginInfoRepository.findByUsername(username);
	}

	// Update token on every login if credentials are correct
	public TokenLoginInfo updateToken(TokenLoginInfo tokenLoginInfo) {
		TokenLoginInfo user = findByUsername(tokenLoginInfo.getUsername());
		user.setToken(tokenLoginInfo.getToken());
		user.setTokenId(tokenLoginInfo.getTokenId());
		user.setFlag(tokenLoginInfo.isFlag());
		user.setLastUpdatedOn(tokenLoginInfo.getLastUpdatedOn());
		System.out.println("user flag " +user);
		return tokenLoginInfoRepository.save(tokenLoginInfo);
	}
	
	public TokenLoginInfo refreshToken(TokenLoginInfo tokenLoginInfo)
	{
		if (tokenLoginInfo.isFlag()) {
			tokenLoginInfo.setLastUpdatedOn(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY));
		return tokenLoginInfoRepository.save(tokenLoginInfo);
		}
		return tokenLoginInfo ;
	}

}
