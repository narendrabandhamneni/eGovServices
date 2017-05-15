package org.egov.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * User
 */

@Data
@Getter
@Setter
@ToString
public class User   {

	private String id;


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


	private String tenantId;


}

