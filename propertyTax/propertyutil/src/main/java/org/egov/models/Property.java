package org.egov.models;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Property
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Property {

	private String id;

	@NonNull
	@Max(value = 128)
	@Min(value=8)
	private String upicNo;
	
	@Max(value = 128)
	@Min(value=8)
	private String oldUpicNo;
	@Max(value = 128)
	@Min(value=4)
	private String vltUpicNo;

	@NonNull
	private String creationReason;

	private Address address;

	private List<User> owners;

	@NonNull

	private String assessmentDate;

	@NonNull

	private String occupancyDate;

	private String gisRefNo;

	private Double longitude;

	private Double latitude;

	private Long revenueZone;

	private Long revenueWard;

	private Long revenueBlock;

	private Long area;

	private Long locality;

	private Long street;

	private Long adminWard;

	private Boolean isAuthorised;

	private Boolean isUnderWorkflow;

	private PropertyBoundary boundary;

	private PropertyDetail propertydetails;

	@NonNull
	@Max(value = 16)
	@Min(value=4)
	private String channel;

	private String createdBy;

	private String createdDate;

	private String lastModifiedBy;

	private String lastModifiedDate;

	@NonNull
	@Max(value =128)
	@Min(value=4)
	private String tenantId;

}
