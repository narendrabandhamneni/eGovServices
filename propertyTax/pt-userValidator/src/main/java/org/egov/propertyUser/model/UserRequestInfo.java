package org.egov.propertyUser.model;

import org.egov.models.RequestInfo;
import org.egov.models.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuppressWarnings("unused")
public class UserRequestInfo {
	
	private User  user;
	
	private RequestInfo requestInfo;
	
	
}
