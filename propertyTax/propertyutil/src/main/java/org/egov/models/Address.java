package org.egov.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Address
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	private String id;

	@Max(value = 32)
	@Min(value=4)
	private String houseNoBldgApt;


	@Max(value = 256)
	@Min(value=4)
	private String streetRoadLine;
	
	@Max(value = 256)
	@Min(value=4)
	private String landmark;

	@Max(value = 256)
	@Min(value=4)
	private String areaLocalitySector;
	
	@Max(value = 256)
	@Min(value=4)
	private String cityTownVillage;
	
	@Max(value =100)
	@Min(value=4)
	private String district;
	
	@Max(value =100)
	@Min(value=4)
	private String subDistrict;
	
	@Max(value =100)
	@Min(value=4)
	private String postOffice;
	
	@Max(value =100)
	@Min(value=4)
	private String state;

	@Max(value =50)
	@Min(value=4)
	private String country;
	
	@Max(value =10)
	@Min(value=6)
	private String pinCode;
	
	@Max(value =50)
	@Min(value=4)
	private String type;

	@NonNull
	@Max(value =128)
	@Min(value=4)
	private String tenantId;
	
	@Max(value =16)
	@Min(value=1)
	private String createdBy;

	private String createdDate;
	
	@Max(value =16)
	@Min(value=1)
	private String lastModifiedBy;

	private String lastModifiedDate;

}
