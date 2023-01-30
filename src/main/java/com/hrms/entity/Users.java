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

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Mahesh Bhakare
 * @version 1.8
 * @date 
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
@Table(name = "users")
public class Users 
{
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId ;
	
	@Column(name = "user_nm")
	private String username ;
	
	@Column(name = "pswd")
	private String password ;
	
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
	
	@ManyToOne
	@JoinColumn(name = "roleId")
	private Roles roles;
	
	
}
