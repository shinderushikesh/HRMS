package com.hrms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.hrms.entity.Employee;

//@EnableJpaRepositories
@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Integer>{
	
	
	public Page<Employee> findAllByOrderByEmpIdDesc(Pageable paging);

}
