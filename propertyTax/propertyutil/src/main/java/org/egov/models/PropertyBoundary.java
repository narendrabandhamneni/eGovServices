package org.egov.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * Boundary
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PropertyBoundary {

	private String id;

	private Double longitude;

	private Double latitude;

	@NonNull
	private String tenantId;

	private Integer revenueZone;

	private String revenueWard;

	private String revenueBlock;

	private String area;

	private String locality;

	private String street;

	private String adminWard;
	
	@Max(value = 256)
	@Min(value=1)
	private String northBoundedBy;

	@Max(value = 256)
	@Min(value=1)
	private String eastBoundedBy;
	
	@Max(value = 256)
	@Min(value=1)
	private String westBoundedBy;
	
	@Max(value = 256)
	@Min(value=1)
	private String southBoundedBy;

	private String createdBy;

	private String createdDate;

	private String lastModifiedBy;

	private String lastModifiedDate;
	
	@Max(value = 256)
	@Min(value=4)
	private String name;

}
