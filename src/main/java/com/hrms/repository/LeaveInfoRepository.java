/**
 * 
 */
package com.hrms.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entity.LeaveInfo;

/**
 * @author Nalanda Gadhire
 *
 */
@Repository
public interface LeaveInfoRepository extends JpaRepository<LeaveInfo, Integer>{

	public LeaveInfo findByFromDate(Date fromDate);

	public Page<LeaveInfo> findAllByOrderByLeaveIdDesc(Pageable paging);

	public LeaveInfo findByAppliedDate(Date appliedDate);

}
