/**
 * 
 */
package com.hrms.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.entity.Roles;
import com.hrms.repository.RolesRepository;

/**
 * @author Dell
 *
 */
@Service
public class RolesService {
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private RolesRepository rolesRepository ;

	public Map<String, Object> getAllRoles() {
		List<Roles> role = new ArrayList<Roles>();
		Session session = entityManager.unwrap(Session.class);
		org.hibernate.Filter filter = session.enableFilter("deletedEmployeeFilter");
		filter.setParameter("isDeleted", false);
		role = rolesRepository.findAllByOrderByRoleId();
		Map<String, Object> response = new HashMap<>();
		response.put("roles", role);
		session.disableFilter("deletedEmployeeFilter");
		if (role != null) {
			return response;
		} else {
			return null;
		}

	}

}
