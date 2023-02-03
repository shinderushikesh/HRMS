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
 * @author Mahesh Bhakare
 * @date 1/2/23
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "attendance_info")
public class AttendanceInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "att_id")
	private Integer attendanceId;

	@Column(name = "rqst_typ")
	private String requestType;

	@Column(name = "rqst_cat")
	private String requestCategory;

	@Column(name = "att_typ")
	private String attendanceType;

	@Column(name = "rqst_dt")
	@JsonFormat(pattern = "EEE MMM d HH:mm:ss z yyyy", shape = Shape.STRING)
	private Date requestDate;

	@Column(name = "mode")
	private String mode;

	@Column(name = "shft_cd")
	private String shiftCode;

	@Column(name = "shft_in")
	private String shiftInTime;

	@Column(name = "shft_out")
	private String shiftOutTime;

	@Column(name = "reason")
	private String reason;

	@ManyToOne
	@JoinColumn(name = "empId")
	private Employee employee;

}
