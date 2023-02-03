package com.hrms.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Rushikesh shinde
 *
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FilterDef(name = "deletedEmployeeFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedEmployeeFilter", condition = "deleted = :isDeleted")
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Integer empId;

	// primary details
	@Column(name = "emp_name")
	private String empName;

	@Column(name = "emp_cd")
	private String empCode;

	@Column(name = "emp_gender")
	private String empGender;

	@Column(name = "emp_dob")
	private String empDOB;

//	@Column(name = "emp_img")
//	private byte[] empimg;

	// Personal Detils

	@Column(name = "nationality")
	private String empNationality;

	@Column(name = " citizenship")
	private String empCitizenship;

	@Column(name = "marital_status")
	private String empMaritalStatus;

	@Column(name = "spouse_name")
	private String empSpouseName;

	@Column(name = "father_name")
	private String empFatherName;

	@Column(name = "passport")
	private String passport;
	
	@Column(name = "passportNo")
	private Integer passportNo;

	@Column(name = "issuePlace")
	private String issuePlace;

	@Column(name = "issueDate")
	private String issueDate;

	@Column(name = "expiryDate")
	private String expiryDate;

	// Contact Details

	@Column(name = "mobile_no")
	private Long mobile;

	@Column(name = "alternate_no")
	private Long altMobile;

	@Column(name = "email")
	private String email;

	@Column(name = "current_address")
	private String currentAddress;

	@Column(name = "permanent_address")
	private String permanentAddress;

	@Column(name = "stay_duration")
	private String stayDuration;

	@Column(name = "pincode_no")
	private Long pinCode;

	// Pan and Address Proof
	@Column(name = "adhar_no")
	private Integer adharNumber;

	@Column(name = "pan_no")
	private String panNumber;

	// Ex- employee

	@Column(name = "employee_id")
	private String emp_Id;

	@Column(name = "designation")
	private String designation;

	@Column(name = "from_to")
	private String fromTO;

	@Column(name = "location")
	private String company_Address;

	@Column(name = "reason")
	private String leaving_reason;

	// Education details

	// SSC//
	@Column(name = "schoolName")
	private String schoolName;

	@Column(name = "periodFrom")
	private Integer periodFrom;

	@Column(name = "ssc_periodTo")
	private Integer periodTo;

	@Column(name = "percentage")
	private Integer percentage;

	// HSC//
	@Column(name = "hscOrDiploma")
	private String hscOrDiploma;

	@Column(name = "collageName")
	private String collageName;

	@Column(name = "join_from")
	private Integer joinFrom;

	@Column(name = "hsc_periodTo")
	private Integer PeriodTo;

	@Column(name = "specialization")
	private String specialization;

	@Column(name = "emp_percentage")
	private Integer percent;

	// Degree//
	@Column(name = "universityName")
	private String universityName;

	@Column(name = "degreePeriodFrom")
	private Integer degreePeriodFrom;

	@Column(name = "degreePeriodTo")
	private Integer degreePeriodTo;

	@Column(name = "degreeSpecialization")
	private String degreeSpecialization;

	@Column(name = "degreePercentage")
	private Integer degreePercentage;

	// pending in excel sheet

	@Column(name = "year_gap")
	private String yrGap;

	@Column(name = "gap_reason")
	private String reason;

	// Previous Employment Details //

	@Column(name = "employer")
	private String employer;

	@Column(name = "businessType")
	private String businessType;

	@Column(name = "emp_Address")
	private String emp_Address;

	@Column(name = "reson_Change")
	private String reson_Change;

	@Column(name = "serviceFrom")
	private String serviceFrom;

	@Column(name = "serviceTo")
	private String serviceTo;

	@Column(name = "drawnCTC")
	private Integer drawnCTC;

	@Column(name = "emp_phone")
	private Long emp_phone;

	@Column(name = "emp_designation")
	private String empdesignation;

	@Column(name = "seniorName")
	private String seniorName;

	@Column(name = "seniorDesignation")
	private String seniorDesignation;

	@Column(name = "currentCTC")
	private Integer currentCTC;

	@Column(name = "expectedCTC")
	private Integer expectedCTC;

	@Column(name = "joinTime")
	private String joinTime;

	@Column(name = "relocation")
	private String relocation;

	// Previous Jobs//
	// Employer 1//

	@Column(name = "employerName1")
	private String employerName1;

	@Column(name = "employerAddress1")
	private String employerAddress1;

	@Column(name = "employerFrom1")
	private String employerFrom1;

	@Column(name = "employerTo1")
	private String employerTo1;

	@Column(name = "employerDesignation1")
	private String employerDesignation1;

	@Column(name = "lastSalary1")
	private String lastSalary1;

	// Employer 2//

	@Column(name = "employerName2")
	private String employerName2;

	@Column(name = "employerAddress2")
	private String employerAddress2;

	@Column(name = "employerFrom2")
	private String employerFrom2;

	@Column(name = "employerTo2")
	private String employerTo2;

	@Column(name = "employerDesignation2")
	private String employerDesignation2;

	@Column(name = "lastSalary2")
	private String lastSalary2;

	@Column(name = "hobbies")
	private String hobbies;

	// Bank Details

	@Column(name = "holderName")
	private String holderName;

	@Column(name = "bankName")
	private String bankName;

	@Column(name = "accountNumber")
	private Long accountNumber;

	@Column(name = "branchName")
	private String branchName;

	@Column(name = "ifscCode")
	private String ifscCode;

	@Column(name = "pfAccountNumber")
	private Long pfAccountNumber;

	@Column(name = "uanNumber")
	private Integer uanNumber;

	@Temporal(TemporalType.DATE)
	@Column(name = "crt_dt")
	private Date createdDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "modi_dt")
	private Date modifiedDate;

	@PrePersist
	private void onCreate() {
		createdDate = new Date();
		modifiedDate = new Date();
	}

	@Column(name = "crt_by")
	private String createdBy;

	@Column(name = "modi_by")
	private String modifiedBy;

	@Column(name = "deleted")
	private Boolean isDeleted = Boolean.FALSE;

}
