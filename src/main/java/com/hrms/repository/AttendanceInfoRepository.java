/**
 * 
 */
package com.hrms.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entity.AttendanceInfo;

/**
 * @author Mahesh Bhakare
 * @date 2/2/23
 */
public interface AttendanceInfoRepository extends JpaRepository<AttendanceInfo, Integer> {

	public AttendanceInfo findByRequestDate(Date requestDate);

	public Page<AttendanceInfo> findAllByOrderByAttendanceIdDesc(Pageable paging);

}
