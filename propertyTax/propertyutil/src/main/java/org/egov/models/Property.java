package org.egov.models;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.ToString;

/**
 * <h1>Property</h1>
 * @author S Anilkumar
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Property {

	private String id;

	private Integer workFlowId;

	@NotNull
	@Size(min = 8, max = 128)
	private String upicNo;

	@Size(min = 8, max = 128)
	private String oldUpicNo;

	@Size(min = 8, max = 128)
	private String vltUpicNo;

	@NotNull
	@Size(min = 1, max = 256)
	private String creationReason;

	@Valid
	private Address address;

	@Valid
	private List<User> owners;

	@NotNull

	private String assessmentDate;

	@NotNull

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

	@Valid
	private PropertyLocation boundary;

	@Valid
	private PropertyDetail propertydetails;

	@NotNull
	@Size(min = 4, max = 16)
	private String channel;

	private AuditDetails auditDetails;

	@NotNull
	@Size(message = "tenantId length should be in between  4 to 128 letters", min = 4, max = 128)
	private String tenantId;

}
