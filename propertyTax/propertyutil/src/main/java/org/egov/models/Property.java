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
public class Property {
	
	private Integer id;
	private String regdDocNo;
	private String regdDocDate;
	private String occupancyDate;
	private String reason;
	private String status;
	private boolean isVerified;
	private String verificationDate;
	private boolean isExempted;
	private String exemptionReason;
	private String propertyType;
	private String category;
	private String usage;
	private String department;
	private String apartment;
	private Double length;
	private Double breadth;
	private Double sitalArea;
	private Double totalBuiltupArea;
	private Double undividedShare;
	@NonNull
	private Integer noOfFloors;
	private Floor floors;
	private boolean isSuperStructure;
	private String landOwner;
	private String floorType;
	private String woodType;
	private String roofType;
	private String wallType;
	private boolean lift;
	private boolean toilet;
	private boolean waterTap;
	private boolean electricity;
	private boolean attachedBathRoom;
	private boolean waterHarvesting;
	private boolean cableConnection;
	private VacantLandProperty vacantLand ;
	
	@NonNull
	private String channel;
	private String applicationNo;
	private Integer createdBy;
	private String createdDate;
	private Integer lastModifiedBy;
	private String lastModifiedDate;
	@NonNull
	private Integer tenantId;
	

}
