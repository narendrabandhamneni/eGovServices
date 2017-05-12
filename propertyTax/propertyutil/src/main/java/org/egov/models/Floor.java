package org.egov.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Floor {

	private Integer id;
	@NonNull
	private String floorNo;
	private String unitNo;
	private String type;
	private Double length;
	private Double width;
	private Double builtupArea;
	private Double assessableArea;
	private Double bpaBuiltupArea;
	private String category;
	@NonNull
	private String usage;
	@NonNull
	private String occupancy;
	@NonNull
	private String structure;
	private String depreciation;
	private String occupierName;
	private String firmName;
	private Double rentCollected;
	private String exemptionReason;
	private boolean isStructured;
	private String occupancyDate;
	private String constCompletionDate;
	private String bpaNo;
	private String bpaDate;
	private Double manualArv;
	private Double arv;
	private String electricMeterNo;
	private String waterMeterNo;
	private Integer createdBy;
	private String createdDate;
	private Integer lastModifiedBy;
	private String lastModifiedDate;
	@NonNull
	private Integer tenantId;
	
}
