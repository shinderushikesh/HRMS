/**
 * 
 */
package com.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entity.Roles;

/**
 * @author Dell
 *
 */
@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer>{

	List<Roles> findAllByOrderByRoleId();

}
