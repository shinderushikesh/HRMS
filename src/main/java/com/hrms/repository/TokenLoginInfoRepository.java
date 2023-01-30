/**
 * 
 */
package com.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entity.TokenLoginInfo;

/**
 * @author Dell
 *
 */
@Repository
public interface TokenLoginInfoRepository extends JpaRepository<TokenLoginInfo, Integer> {

	public TokenLoginInfo findByUsername(String username);
}
