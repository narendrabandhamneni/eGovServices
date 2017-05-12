package org.egov.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	
	private Integer id;
	private String username;
	private String title;
	private String salutation;
	private String guardian;
	private String guardianRelation;
	private String name;
	private String gender;
	private String mobileNumber;
	private String emailId;
	private String pan;
	private String aadhaarNumber;
	private String type;
	private Integer tenantId;
	
	
	
	

}
