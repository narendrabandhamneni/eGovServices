package org.egov.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * PropertyDetail
 * Author : narendra
 */

public class PropertyDetail   {
	@JsonProperty("id")
	private Long id = null;

	/**
	 * Source of a assessment data. The properties will be created in a system based on the data avaialble in their manual records or during field survey. There can be more from client to client.
	 */
	public enum SourceEnum {
		MUNICIPAL_RECORDS("MUNICIPAL_RECORDS"),

		FIELD_SURVEY("FIELD_SURVEY");

		private String value;

		SourceEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static SourceEnum fromValue(String text) {
			for (SourceEnum b : SourceEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("source")
	@Size(min=1,max=64)
	private SourceEnum source = null;

	@JsonProperty("regdDocNo")
	@Size(min=1,max=64)
	private String regdDocNo = null;

	@JsonProperty("regdDocDate")
	private String regdDocDate = null;

	@JsonProperty("reason")
	@Size(min=1,max=16)
	private String reason = null;

	/**
	 * status of the Property
	 */
	public enum StatusEnum {
		ACTIVE("ACTIVE"),

		INACTIVE("INACTIVE"),

		WORKFLOW("WORKFLOW"),

		HISTORY("HISTORY"),

		CANCELED("CANCELED");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StatusEnum fromValue(String text) {
			for (StatusEnum b : StatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("status")
	@Size(min=1,max=8)
	private StatusEnum status = null;

	@JsonProperty("isVerified")
	private Boolean isVerified = null;

	@JsonProperty("verificationDate")
	private String verificationDate = null;

	@JsonProperty("isExempted")
	private Boolean isExempted = false;

	@JsonProperty("exemptionReason")
	@Size(min=1,max=32)
	private String exemptionReason = null;

	@JsonProperty("propertyType")
	@NotNull
	@Size(min=1,max=16)
	private String propertyType = null;

	@JsonProperty("category")
	@Size(min=1,max=16)
	private String category = null;

	@JsonProperty("usage")
	@Size(min=1,max=16)
	private String usage = null;

	@JsonProperty("department")
	@Size(min=1,max=16)
	private String department = null;

	@JsonProperty("apartment")
	@Size(min=1,max=16)
	private String apartment = null;

	@JsonProperty("siteLength")
	private Double siteLength = null;

	@JsonProperty("siteBreadth")
	private Double siteBreadth = null;

	@JsonProperty("sitalArea")
	@NotNull
	private Double sitalArea = null;

	@JsonProperty("totalBuiltupArea")
	private Double totalBuiltupArea = null;

	@JsonProperty("undividedShare")
	private Double undividedShare = null;

	@JsonProperty("noOfFloors")
	private Long noOfFloors = null;

	@JsonProperty("isSuperStructure")
	private Boolean isSuperStructure = false;

	@JsonProperty("landOwner")
	@Size(min=1,max=128)
	private String landOwner = null;

	@JsonProperty("floorType")
	@Size(min=1,max=16)
	private String floorType = null;

	@JsonProperty("woodType")
	@Size(min=1,max=16)
	private String woodType = null;

	@JsonProperty("roofType")
	@Size(min=1,max=16)
	private String roofType = null;

	@JsonProperty("wallType")
	@Size(min=1,max=16)
	private String wallType = null;

	@JsonProperty("floors")
	private List<Floor> floors = new ArrayList<Floor>();

	@JsonProperty("documents")
	private List<Document> documents = new ArrayList<Document>();

	@JsonProperty("stateId")
	private String stateId = null;

	@JsonProperty("applicationNo")
	@Size(min=1,max=64)
	private String applicationNo = null;

	@JsonProperty("workFlowDetails")
	private WorkFlowDetails workFlowDetails = null;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SourceEnum getSource() {
		return source;
	}

	public void setSource(SourceEnum source) {
		this.source = source;
	}

	public String getRegdDocNo() {
		return regdDocNo;
	}

	public void setRegdDocNo(String regdDocNo) {
		this.regdDocNo = regdDocNo;
	}

	public String getRegdDocDate() {
		return regdDocDate;
	}

	public void setRegdDocDate(String regdDocDate) {
		this.regdDocDate = regdDocDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public String getVerificationDate() {
		return verificationDate;
	}

	public void setVerificationDate(String verificationDate) {
		this.verificationDate = verificationDate;
	}

	public Boolean getIsExempted() {
		return isExempted;
	}

	public void setIsExempted(Boolean isExempted) {
		this.isExempted = isExempted;
	}

	public String getExemptionReason() {
		return exemptionReason;
	}

	public void setExemptionReason(String exemptionReason) {
		this.exemptionReason = exemptionReason;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public Double getSiteLength() {
		return siteLength;
	}

	public void setSiteLength(Double siteLength) {
		this.siteLength = siteLength;
	}

	public Double getSiteBreadth() {
		return siteBreadth;
	}

	public void setSiteBreadth(Double siteBreadth) {
		this.siteBreadth = siteBreadth;
	}

	public Double getSitalArea() {
		return sitalArea;
	}

	public void setSitalArea(Double sitalArea) {
		this.sitalArea = sitalArea;
	}

	public Double getTotalBuiltupArea() {
		return totalBuiltupArea;
	}

	public void setTotalBuiltupArea(Double totalBuiltupArea) {
		this.totalBuiltupArea = totalBuiltupArea;
	}

	public Double getUndividedShare() {
		return undividedShare;
	}

	public void setUndividedShare(Double undividedShare) {
		this.undividedShare = undividedShare;
	}

	public Long getNoOfFloors() {
		return noOfFloors;
	}

	public void setNoOfFloors(Long noOfFloors) {
		this.noOfFloors = noOfFloors;
	}

	public Boolean getIsSuperStructure() {
		return isSuperStructure;
	}

	public void setIsSuperStructure(Boolean isSuperStructure) {
		this.isSuperStructure = isSuperStructure;
	}

	public String getLandOwner() {
		return landOwner;
	}

	public void setLandOwner(String landOwner) {
		this.landOwner = landOwner;
	}

	public String getFloorType() {
		return floorType;
	}

	public void setFloorType(String floorType) {
		this.floorType = floorType;
	}

	public String getWoodType() {
		return woodType;
	}

	public void setWoodType(String woodType) {
		this.woodType = woodType;
	}

	public String getRoofType() {
		return roofType;
	}

	public void setRoofType(String roofType) {
		this.roofType = roofType;
	}

	public String getWallType() {
		return wallType;
	}

	public void setWallType(String wallType) {
		this.wallType = wallType;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public WorkFlowDetails getWorkFlowDetails() {
		return workFlowDetails;
	}

	public void setWorkFlowDetails(WorkFlowDetails workFlowDetails) {
		this.workFlowDetails = workFlowDetails;
	}

	public AuditDetails getAuditDetails() {
		return auditDetails;
	}

	public void setAuditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
	}

	@Override
	public String toString() {
		return "PropertyDetail [id=" + id + ", source=" + source + ", regdDocNo=" + regdDocNo + ", regdDocDate="
				+ regdDocDate + ", reason=" + reason + ", status=" + status + ", isVerified=" + isVerified
				+ ", verificationDate=" + verificationDate + ", isExempted=" + isExempted + ", exemptionReason="
				+ exemptionReason + ", propertyType=" + propertyType + ", category=" + category + ", usage=" + usage
				+ ", department=" + department + ", apartment=" + apartment + ", siteLength=" + siteLength
				+ ", siteBreadth=" + siteBreadth + ", sitalArea=" + sitalArea + ", totalBuiltupArea=" + totalBuiltupArea
				+ ", undividedShare=" + undividedShare + ", noOfFloors=" + noOfFloors + ", isSuperStructure="
				+ isSuperStructure + ", landOwner=" + landOwner + ", floorType=" + floorType + ", woodType=" + woodType
				+ ", roofType=" + roofType + ", wallType=" + wallType + ", floors=" + floors + ", documents="
				+ documents + ", stateId=" + stateId + ", applicationNo=" + applicationNo + ", workFlowDetails="
				+ workFlowDetails + ", auditDetails=" + auditDetails + "]";
	}
}

