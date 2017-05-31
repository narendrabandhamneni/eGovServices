package org.egov.propertyWorkflow.models;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class Designation {
	
	private Long id;
	private String name;
	private String code;
	private String description;
	private String chartOfAccounts;
	private Boolean active;
	private String tenantId;
}
