package org.egov.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * PropertyDetail
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PropertyDetail {

	private String id;

	@Max(value =64)
	@Min(value=1)
	private String regdDocNo;

	private String regdDocDate;

	private String occupancyDate;

	@Max(value =16)
	@Min(value=1)
	private String reason;
	
	@Max(value =4)
	@Min(value=1)
	private String status;

	private Boolean isVerified;

	private String verificationDate;

	private Boolean isExempted;
	
	@Max(value =32)
	@Min(value=1)
	private String exemptionReason;
	
	@Max(value =16)
	@Min(value=1)
	private String propertyType;
	
	@Max(value =16)
	@Min(value=1)
	private String category;
	
	@Max(value =16)
	@Min(value=1)
	private String usage;
	
	@Max(value =16)
	@Min(value=1)
	private String department;
	
	@Max(value =16)
	@Min(value=1)
	private String apartment;

	private Double length;

	private Double breadth;

	private Double sitalArea;

	private Double totalBuiltupArea;

	private Double undividedShare;

	private Long noOfFloors;

	private List<Floor> floors;

	private Boolean isSuperStructure;
	
	@Max(value =128)
	@Min(value=1)
	private String landOwner;
	
	@Max(value =16)
	@Min(value=1)
	private String floorType;

	@Max(value =16)
	@Min(value=1)
	private String woodType;
	
	@Max(value =16)
	@Min(value=1)
	private String roofType;
	
	@Max(value =16)
	@Min(value=1)
	private String wallType;

	private Boolean lift;

	private Boolean toilet;

	private Boolean waterTap;

	private Boolean electricity;

	private Boolean attachedBathRoom;

	private Boolean waterHarvesting;

	private Boolean cableConnection;

	private VacantLandProperty vacantLand;

	@NonNull
	@Max(value =16)
	@Min(value=4)
	private String channel;
	
	@Max(value =32)
	@Min(value=1)
	private String applicationNo;

	private String createdBy;

	private String createdDate;

	private String lastModifiedBy;

	private String lastModifiedDate;

	@NonNull
	@Max(value =128)
	@Min(value=4)
	private String tenantId;

}
