/**
 * 
 */
package com.hrms.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Dell
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "token_info")
public class TokenLoginInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="token_id")
	private Long TokenId;
	
	@Column(name="token")
	private String token;
	// login true and otherwise false
	
	@Column(name="flag")
	private boolean flag;
	
	@Column(name="username")
	private String username;
	
	@Column(name="last_updated_on")
	private Date lastUpdatedOn;

}
