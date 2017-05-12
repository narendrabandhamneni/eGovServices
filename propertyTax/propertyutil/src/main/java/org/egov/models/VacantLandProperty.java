package org.egov.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VacantLandProperty {
	private Integer id;
	private String surveyNumber;
	private String pattaNumber;
	private Double marketValue;
	private Double capitalValue;
	private String layoutApprovedAuth;
	private String layoutPermissionNo;
	private String layoutPermissionDate;
	private Double resdPlotArea;
	private Double nonResdPlotArea;
	private Integer createdBy;
	private String createdDate;
	private Integer lastModifiedBy;
	private String lastModifiedDate;
	@NonNull
	private Integer tenantId;
	
	

}
