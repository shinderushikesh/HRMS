/**
 * 
 */
package com.hrms.controller;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.entity.AttendanceInfo;
import com.hrms.exception.CustomException;
import com.hrms.services.AttendanceInfoService;

/**
 * @author Mahesh Bhakare
 * @date 2/2/23
 */
@RestController
@RequestMapping("/hrms/api")
public class AttendanceInfoController {

	@Autowired
	private AttendanceInfoService attendanceInfoService;

//	private static final Logger logger = LoggerFactory.getLogger(AttendanceInfoController.class);

	// Add Swap Request
	@PostMapping("/attendance/{empId}")
	public ResponseEntity<Object> addAttendance(@RequestBody AttendanceInfo attendanceInfo,
			@PathVariable Integer empId) {
		AttendanceInfo attendance = null;
		try {
//			logger.info("Saving Attendance- {}", attendanceInfo.getRequestCategory());
			attendance = attendanceInfoService.addAttendance(attendanceInfo, empId);
		} catch (Exception e) {
			String message = "attendance is not applied.";
			String details = "The Attendance is already applied.";
			return new ResponseEntity<Object>(new CustomException(message, details), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(attendance, HttpStatus.OK);
	}

	// Get All Swap Request
	@GetMapping("/allAttendence")
	public ResponseEntity<Object> getAllEmployee(@RequestParam(defaultValue = "1") Integer pageNo,
			@RequestParam(defaultValue = "5") Integer pageSize) {

		Map<String, Object> attend = attendanceInfoService.getAllAttendence(pageNo, pageSize);
		if (attend == null) {
			String message = "Applied attendance is not found";
			String details = "Please check that data exists";
			System.out.println(message + "," + details);
			return new ResponseEntity<Object>(new CustomException(message, details), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(attend, HttpStatus.OK);
	}

	// Get All Swap Request
	@GetMapping("/get-by-requestDate/{requestDate}")
	public ResponseEntity<Object> getAllByRequestDate(@PathVariable Date requestDate) {
//		logger.info("getAllByRequestDate() Method called.");
		Map<String, Object> attend = attendanceInfoService.getAllByRequestDate(requestDate);
		if (attend == null) {
			String message = "Applied attendance is not found";
			String details = "Please check that data exists";
			System.out.println(message + "," + details);
			return new ResponseEntity<Object>(new CustomException(message, details), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(attend, HttpStatus.OK);
	}

	// Delete Attendance by request Date
	@Transactional
	@DeleteMapping("/attendance/{requestDate}")
	public ResponseEntity<Object> deleteAttendance(@PathVariable Date requestDate) {
//		logger.info("deleteAttendance() method is called.");
		try {
			attendanceInfoService.deleteAttendance(requestDate);
		} catch (Exception e) {
//			logger.error("Error occured -", e);
			return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Attendance deleted", HttpStatus.OK);
	}
}
