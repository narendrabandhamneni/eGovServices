package org.egov.models;

import java.util.List;

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
public class BasicProperty {

	private Integer id;
	@NonNull
	private String upicNo;
	private String oldUpicNo;
	private String vltUpicNo;
	@NonNull
	private String creationReason;
	private Address address;
	private Object[] owners;
	@NonNull
	private String assessmentDate;
	@NonNull
	private String occupancyDate;
	private String gisRefNo;
	private double longitude;
	private double latitude;
	private int revenueZone;
	private int revenueWard;
	private int revenueBlock;
	private int area;
	private int locality;
	private int street;
	private int adminWard;
	private boolean isAuthorised;
	private boolean isUnderWorkflow;
	private String northBoundedBy;
	private String eastBoundedBy;
	private String westBoundedBy;
	private String southBoundedBy;
	private List<PropertyDetail> propertyDetails;
	@NonNull
	private String channel;
	private int createdBy;
	private String createdDate;
	private int lastModifiedBy;
	private String lastModifiedDate;

	@NonNull
	private String tenantId;
	
	
	
	
	
	
}
