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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.hrms.entity.Employee;
import com.hrms.repository.EmployeeRespository;

/**
 * @author Rushikesh shinde
 *
 */

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

	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub

		if (employeeRespository.findByempCode(employee.getEmpCode()) != null)
			throw new RuntimeException("The Employee code is already exits");

		return employeeRespository.save(employee);
	}

	// get by Employee Code
	public Employee getByEmployeeCode(String emp_cd) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		org.hibernate.Filter filter = session.enableFilter("deletedEmployeeFilter");
		filter.setParameter("isDeleted", false);
		Employee EmployeeEntity = employeeRespository.findByempCode(emp_cd);
		session.disableFilter("deletedEmployeeFilter");
		return EmployeeEntity;
	}

	// soft delete Employee
	public void deleteEmployee(String emp_cd) {
		// TODO Auto-generated method stub
		Employee employeeDelete = getByEmployeeCode(emp_cd);
		employeeDelete.setIsDeleted(true);
		employeeRespository.save(employeeDelete);
	}

	// update Employee
	public Employee updateEmp(Employee emp, String emp_cd) {
		Employee updateEmployee = getByEmployeeCode(emp_cd);
		if (updateEmployee != null) {
			updateEmployee.setEmpName(emp.getEmpName());
		}
		return employeeRespository.save(updateEmployee);
	}

	public List<Employee> getAllEmployeeNoPaged() {
		// TODO Auto-generated method stub
		List<Employee> employee = employeeRespository.findAll();
		if (employee != null) {
			return employee;
		} else {
			return null;
		}
	}

}
