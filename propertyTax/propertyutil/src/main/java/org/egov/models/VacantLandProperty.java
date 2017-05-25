package org.egov.models;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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

	@Max(value =64)
	@Min(value=4)
	private String surveyNumber;
	
	@Max(value =64)
	@Min(value=4)
	private String pattaNumber;

	private Double marketValue;

	private Double capitalValue;
	
	@Max(value =64)
	@Min(value=4)
	private String layoutApprovedAuth;
	
	@Max(value =64)
	@Min(value=4)
	private String layoutPermissionNo;

	private String layoutPermissionDate;

	private Double resdPlotArea;

	private Double nonResdPlotArea;
	
	@Max(value =16)
	@Min(value=1)
	private String createdBy;

	private String createdDate;
	
	@Max(value =16)
	@Min(value=1)
	private String lastModifiedBy;

	private String lastModifiedDate;

	@NonNull
	@Max(value =128)
	@Min(value=4)
	private String tenantId;

}
