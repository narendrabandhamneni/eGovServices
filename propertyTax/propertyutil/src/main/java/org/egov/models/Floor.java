package org.egov.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Floor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Floor {
	//@NonNull
	private String id;

	@NonNull
	@Max(value =16)
	@Min(value=1)
	private String floorNo;
	
	@Max(value =8)
	@Min(value=1)
	private String unitNo;
	
	@Max(value =16)
	@Min(value=1)
	private String type;

	private Double length;

	private Double width;

	@NonNull
	private Double builtupArea;

	private Double assessableArea;

	private Double bpaBuiltupArea;

	@Max(value =16)
	@Min(value=1)
	private String category;

	@NonNull
	@Max(value =16)
	@Min(value=1)
	private String usage;

	@NonNull
	@Max(value =16)
	@Min(value=1)
	private String occupancy;

	@NonNull
	@Max(value =16)
	@Min(value=1)
	private String structure;

	@Max(value =16)
	@Min(value=1)
	private String depreciation;
	
	@Max(value =128)
	@Min(value=1)
	private String occupierName;
	
	@Max(value =128)
	@Min(value=1)
	private String firmName;

	private Double rentCollected;

	@Max(value =32)
	@Min(value=1)
	private String exemptionReason;

	private Boolean isStructured;

	private String occupancyDate;

	private String constCompletionDate;

	@Max(value =16)
	@Min(value=1)
	private String bpaNo;

	private String bpaDate;

	private Double manualArv;

	private Double arv;

	@Max(value =64)
	@Min(value=1)
	private String electricMeterNo;
	
	@Max(value =64)
	@Min(value=1)
	private String waterMeterNo;

	private String createdBy;

	private String createdDate;

	private String lastModifiedBy;

	private String lastModifiedDate;
	
    @NonNull
    @Max(value =128)
	@Min(value=4)
	private String tenantId;

}
