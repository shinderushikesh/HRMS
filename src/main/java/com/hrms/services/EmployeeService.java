package com.hrms.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import com.hrms.entity.Employee;
import com.hrms.repository.EmployeeRespository;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private EmployeeRespository employeeRespository;

	public Map<String, Object> getAllEmployees(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List<Employee> employee = new ArrayList<Employee>();
		Session session = entityManager.unwrap(Session.class);
		org.hibernate.Filter filter = session.enableFilter("deletedEmployeeFilter");
		filter.setParameter("isDeleted", false);
		Pageable paging = PageRequest.of(pageNo - 1, pageSize);
		Page<Employee> emp = employeeRespository.findAllByOrderByEmpIdDesc(paging);
		employee = emp.getContent();
		Map<String, Object> response = new HashMap<>();
		response.put("emp", emp);
		response.put("currentPage", emp.getNumber());
		response.put("totalItems", emp.getTotalElements());
		response.put("totalPages", emp.getTotalPages());
		session.disableFilter("deletedEmployeeFilter");
		if (emp.hasContent()) {
			return response;
		} else {
			return null;
		}

	}

}
