package org.egov.models;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * User
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class User {

	private String id;
	@Max(value = 64)
	@Min(value=1)
	private String username;

	private String password;
	
	@Max(value = 5)
	@Min(value=1)
	private String salutation;
	
	@Max(value = 100)
	@Min(value=1)
	private String name;
	
	@Max(value = 8)
	@Min(value=1)
	private String gender;
	
	@Max(value =10)
	@Min(value=1)
	private String mobileNumber;
	
	@Max(value =128)
	@Min(value=1)
	private String emailId;

	private String altContactNumber;
	
	@Max(value =10)
	@Min(value=1)
	private String pan;
	
	@Max(value =12)
	@Min(value=1)
	private String aadhaarNumber;

	private String permanentAddress;

	private String permanentPincode;

	private String permanentCity;

	private String correspondenceCity;

	private String correspondencePincode;

	private String correspondenceAddress;

	private Boolean active;

	private String dob;

	private String locale;

	private Boolean accountLocked;

	private String signature;
	
	@Max(value =16)
	@Min(value=1)
	private String type;
	
	@Max(value = 8)
	@Min(value=1)
	private String title;
	
	@Max(value = 100)
	@Min(value=1)
	private String guardian;
	
	@Max(value =32)
	@Min(value=1)
	private String guardianRelation;

	private String fatherOrHusbandName;

	private String bloodGroup;

	private String identificationMark;

	private String photo;

	private Integer createdBy;

	private String createdDate;

	private Integer lastModifiedBy;

	private String lastModifiedDate;

	private String otpReference;
	
	@NonNull
	@Max(value =128)
	@Min(value=4)
	private String tenantId;

	private List<Role> roles;

}
