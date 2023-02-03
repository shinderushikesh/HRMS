/**
 * 
 */
package com.hrms.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrms.entity.AttendanceInfo;
import com.hrms.entity.Employee;
import com.hrms.repository.AttendanceInfoRepository;

/**
 * @author Mahesh Bhakare
 * @date 2/2/23
 */
@Service
public class AttendanceInfoService {
	@Autowired
	private AttendanceInfoRepository attendanceInfoRepository;

//	private static final Logger logger = LoggerFactory.getLogger(AttendanceInfoService.class);

	// Add Swap Request
	public AttendanceInfo addAttendance(AttendanceInfo attendanceInfo, Integer empId) {
//		logger.info("addAttendance() method called");
		AttendanceInfo attendance = attendanceInfo;
		try {
			if (attendanceInfoRepository.findByRequestDate(attendanceInfo.getRequestDate()) == null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("The Attendance already applied.");
		}
		return attendanceInfoRepository.save(attendance);
	}

	// Get All Swap Request
	public Map<String, Object> getAllAttendence(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		List<AttendanceInfo> obj = new ArrayList<AttendanceInfo>();
		Pageable paging = PageRequest.of(pageNo - 1, pageSize);
		Page<AttendanceInfo> attendform = attendanceInfoRepository.findAllByOrderByAttendanceIdDesc(paging);
		obj = attendform.getContent();
		Map<String, Object> response = new HashMap<>();
		response.put("AttendenceInfo", attendform);
		response.put("currentPage", attendform.getNumber());
		response.put("totleItems", attendform.getTotalElements());
		response.put("totalePages", attendform.getTotalPages());
		if (attendform.hasContent()) {
			return response;
		} else {
			return null;
		}
	}

	// Get All Swap Request
	public Map<String, Object> getAllByRequestDate(Date requestDate) {
//		logger.info("getAllByRequestDate() Method called.");
		AttendanceInfo attendenceInfo = attendanceInfoRepository.findByRequestDate(requestDate);
		Map<String, Object> response = new HashMap<>();
		response.put("AttendenceInfo", attendenceInfo);
		if (attendenceInfo != null) {
			return response;
		} else {
			return null;
		}
	}

	// Delete Attendance by request Date
	public void deleteAttendance(Date requestDate) {
//		logger.info("deleteAttendance() method is called.");
		AttendanceInfo attendanceInfo = new AttendanceInfo();
		try {
			attendanceInfo = attendanceInfoRepository.findByRequestDate(requestDate);
			if (attendanceInfo != null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("The Attendance is not found.");
		}
		attendanceInfoRepository.delete(attendanceInfo);
	}

}
