/**
 * 
 */
package com.hrms.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Nalanda Gadhire
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "leave_info")
public class LeaveInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="leave_id")
	private Integer leaveId;

	@Column(name = "app_dt")
	@JsonFormat(pattern = "EEE MMM d HH:mm:ss z yyyy", shape = Shape.STRING)
	private Date appliedDate;

	
	@Column(name = "fr_dt")
	@JsonFormat(pattern = "EEE MMM d HH:mm:ss z yyyy", shape = Shape.STRING)
    private Date fromDate;	

	@Column(name = "start_dy")
	private String startDay;

	@Column(name = "first_hlf")
	private String firstHalf;

	@Column(name = "lst_dy")
	private String lastDay;

	@Column(name = "scnd_hlf")
	private String secondHalf;

	@Column(name = "to_dt")
	@JsonFormat(pattern = "EEE MMM d HH:mm:ss z yyyy", shape = Shape.STRING)
	private Date toDate;

	@Column(name = "total_dys")
	private Integer totalDays;

	@Column(name = "leave_typ")
	private String leaveType;

	@Column(name = "reason")
	private String reason;

	@ManyToOne
	@JoinColumn(name = "empId")
	private Employee employee;

}
