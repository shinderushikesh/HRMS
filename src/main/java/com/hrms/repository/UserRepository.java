/**
 * 
 */
package com.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrms.entity.Users;


/**
 * @author Mahesh Bhakare
 * @version 1.8
 * @date 
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Integer>
{
	/*
	 * @Query("select ui from usermst  ui where ui.user_cd =:user_name") public
	 * UserInfo findByUsername(@RequestParam ("user_name") String user_name);
	 */

	//Users findByUsername(String username);
	
	public Users findByUsername(String username);
	
	
}
