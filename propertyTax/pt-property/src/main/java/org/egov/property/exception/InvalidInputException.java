package org.egov.property.exception;

import org.egov.models.RequestInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class InvalidInputException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RequestInfo requestInfo;
	
	
}
