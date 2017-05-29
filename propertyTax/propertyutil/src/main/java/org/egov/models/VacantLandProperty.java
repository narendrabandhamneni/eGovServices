package org.egov.models;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * VacantLandProperty
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VacantLandProperty {

	private String id;

	@Size(min=4, max=64)
	private String surveyNumber;
	
	@Size(min=4, max=64)
	private String pattaNumber;

	private Double marketValue;

	private Double capitalValue;
	
	@Size(min=4, max=64)
	private String layoutApprovedAuth;
	
	@Size(min=4, max=64)
	private String layoutPermissionNo;

	private String layoutPermissionDate;

	private Double resdPlotArea;

	private Double nonResdPlotArea;
	
	private AuditDetails auditDetails;

	@NonNull
	@Size(min=4, max=128)
	private String tenantId;

}
