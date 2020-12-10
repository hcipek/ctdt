package com.cipek.ctdt.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BaseException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5219696788890779392L;
	
	private String reasonMessage;

}
