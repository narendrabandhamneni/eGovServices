package org.egov.propertyUser.model;

import java.util.List;

import org.egov.models.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {

	private String id;
	private String userName;
	private String name;
	private String mobileNumber;
	private String emailId;
	private String locale;
	private String type;
	private List<Role> roles;
}