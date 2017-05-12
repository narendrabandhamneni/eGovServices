package org.egov.property.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiErrorResponse {

	private String code;
	
	private String message;
	
	private String description;
	
	public ApiErrorResponse(String code, String message, String status) {
		super();
		this.code = code;
		this.message = message;
		Status = status;
	}

	private String Status;
	
	
	
}
