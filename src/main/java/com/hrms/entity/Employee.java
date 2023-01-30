package com.hrms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


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
	
	@Column(name = "emd_cd")
	private String emdCd;
	
	@Column(name = "empDept_nm")
	private String empDeptNm;
	
	@Column(name = "crt_dt")
	private Date createdDate ;
	
	@Column(name = "modi_dt")
	private Date modifiedDate ;
	
	@Column(name = "crt_by")
	private String createdBy ;
	
	@Column(name = "modi_by")
	private String modifiedBy ;
	
	@Column(name = "deleted")
	private Boolean isDeleted = Boolean.FALSE;

}
