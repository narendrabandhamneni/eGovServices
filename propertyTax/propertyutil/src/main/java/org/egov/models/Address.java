package org.egov.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
	
	private Integer id;
	private String houseNoBldgApt;
	private String streetRoadLine;
	private String landmark;
	private String areaLocalitySector;
	private String cityTownVillage;
	private String district;
	private String subDistrict;
	private String postOffice;
	private String state;
	private String country;
	private String pinCode;
	private String type;
	private String tenantId;

}
