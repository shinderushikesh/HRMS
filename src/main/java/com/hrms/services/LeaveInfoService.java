package com.hrms.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hrms.entity.LeaveInfo;
import com.hrms.repository.LeaveInfoRepository;

/**
 * @author Nalanda Gadhire
 *
 */
@Service
public class LeaveInfoService {

	@Autowired
	private LeaveInfoRepository leaveInfoRepository;

	@Autowired
	private EntityManager entityManager;

	public LeaveInfo add(LeaveInfo leaveInfo) {
		try {
			if (leaveInfoRepository.findByAppliedDate(leaveInfo.getAppliedDate()) == null)
				;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("The Leave is already applied.");
		}
		return leaveInfoRepository.save(leaveInfo);
	}

	public Map<String, Object> getAllLeaves(int pageNo, int pageSize) {
		List<LeaveInfo> obj = new ArrayList<LeaveInfo>();
		Pageable paging = PageRequest.of(pageNo - 1, pageSize);
		Page<LeaveInfo> leaveInfom = leaveInfoRepository.findAllByOrderByLeaveIdDesc(paging);
		obj = leaveInfom.getContent();
		Map<String, Object> response = new HashMap<>();
		response.put("LeaveInfo", leaveInfom);
		response.put("currentPage", leaveInfom.getNumber());
		response.put("totleItems", leaveInfom.getTotalElements());
		response.put("totalePages", leaveInfom.getTotalPages());
		if (leaveInfom.hasContent()) {
			return response;
		} else {
			return null;
		}
	}

	public Map<String, Object> getAllLeaveByAppliedDate(Date appliedDate) {
		List<LeaveInfo> obj = new ArrayList<LeaveInfo>();
		LeaveInfo leaveInfom = leaveInfoRepository.findByAppliedDate(appliedDate);
		Map<String, Object> response = new HashMap<>();
		response.put("LeaveInfo", leaveInfom);
		if (leaveInfom != null) {
			return response;
		} else {
			return null;
		}
	}
	// Delete Leave
	public void deleteLeave(Date appliedDate) {
		LeaveInfo leave = leaveInfoRepository.findByAppliedDate(appliedDate);
		leaveInfoRepository.delete(leave);
	}

}
