package com.hrms.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private String details;
	

}
