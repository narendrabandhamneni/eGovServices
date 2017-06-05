package org.egov.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String dob;
	
	private String altContactNumber;
	
	private String fatherName;
	
	private String husbandName;
	
	private String pan;
	
	private String bloodGroup;
	
	private String permanentAddress;
	
	private String permanentCity;
	
	private String permanentPincode;
	
	private String correspondenceCity;
	
	private String correspondencePincode;
	
	private String correspondenceAddress;
	
	private String signature;
	
	private String identificationMark;
	
	private String photo;
}
