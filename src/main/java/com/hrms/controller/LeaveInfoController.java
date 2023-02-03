
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

import com.hrms.entity.LeaveInfo;
import com.hrms.exception.CustomException;
import com.hrms.services.LeaveInfoService;

/**
 * @author Nalanda Gadhire
 *
 */
@RestController
@RequestMapping("/hrms/api")
public class LeaveInfoController {

	@Autowired
	private LeaveInfoService leaveInfoService;

//	private static final Logger logger = LoggerFactory.getLogger(LeaveInfoController.class);

	// save new leave record
	@PostMapping("/leave")
	public ResponseEntity<Object> addLeave(@RequestBody LeaveInfo leaveInfo) {
		LeaveInfo leave = null;
		try {
			leave = leaveInfoService.add(leaveInfo);
//			logger.info("Saving leave- {}");
		} catch (Exception e) {
			return new ResponseEntity<Object>(new CustomException(e.getLocalizedMessage(), e.getMessage()),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(leave, HttpStatus.OK);
	}

	@GetMapping("/allLeaves")
	public ResponseEntity<Object> getAllEmployee(@RequestParam(defaultValue = "1") Integer pageNo,
			@RequestParam(defaultValue = "5") Integer pageSize) {
		Map<String, Object> leave = leaveInfoService.getAllLeaves(pageNo, pageSize);
		if (leave == null) {
			String message = "Leave is not Applied";
			String details = "Please check that data exists";
			System.out.println(message + "," + details);
			return new ResponseEntity<Object>(new CustomException(message, details), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(leave, HttpStatus.OK);
	}

	// leave by date
	@GetMapping("/allLeaves/{appliedDate}")
	public ResponseEntity<Object> getAllLeaveByAppliedDate(@PathVariable Date appliedDate) {
		Map<String, Object> leave = leaveInfoService.getAllLeaveByAppliedDate(appliedDate);
		if (leave == null) {
			String message = "Leave is not Applied";
			String details = "Please check that data exists";
			System.out.println(message + "," + details);
			return new ResponseEntity<Object>(new CustomException(message, details), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(leave, HttpStatus.OK);
	}

	// Soft Delete PU
	@Transactional
	@DeleteMapping("/leave/{appliedDate}")
	public ResponseEntity<Object> deleteLeave(@PathVariable Date appliedDate) {
		try {
			leaveInfoService.deleteLeave(appliedDate);
		} catch (Exception e) {
//			logger.error("Error occured -", e);
			return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Leave is deleted", HttpStatus.OK);
	}

}
