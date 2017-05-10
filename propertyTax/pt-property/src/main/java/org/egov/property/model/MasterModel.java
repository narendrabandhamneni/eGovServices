package org.egov.property.model;

import lombok.Data;


@Data
public class MasterModel {

	private long tenantId;
	
	private int code;
	
	private String name;
	
	private String description;
}
