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

	public PropertyDetail id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique Identifier of the PropertyDetail
	 * @return id
	 **/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PropertyDetail source(SourceEnum source) {
		this.source = source;
		return this;
	}

	/**
	 * Source of a assessment data. The properties will be created in a system based on the data avaialble in their manual records or during field survey. There can be more from client to client.
	 * @return source
	 **/
	public SourceEnum getSource() {
		return source;
	}

	public void setSource(SourceEnum source) {
		this.source = source;
	}

	public PropertyDetail regdDocNo(String regdDocNo) {
		this.regdDocNo = regdDocNo;
		return this;
	}

	/**
	 * Property registered no from Registration Department.
	 * @return regdDocNo
	 **/

	public String getRegdDocNo() {
		return regdDocNo;
	}

	public void setRegdDocNo(String regdDocNo) {
		this.regdDocNo = regdDocNo;
	}

	public PropertyDetail regdDocDate(String regdDocDate) {
		this.regdDocDate = regdDocDate;
		return this;
	}

	/**
	 * roperty registered date from Registration Department.
	 * @return regdDocDate
	 **/
	public String getRegdDocDate() {
		return regdDocDate;
	}

	public void setRegdDocDate(String regdDocDate) {
		this.regdDocDate = regdDocDate;
	}

	public PropertyDetail reason(String reason) {
		this.reason = reason;
		return this;
	}

	/**
	 * reason of the PropertyDetail
	 * @return reason
	 **/
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public PropertyDetail status(StatusEnum status) {
		this.status = status;
		return this;
	}

	/**
	 * status of the Property
	 * @return status
	 **/
	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public PropertyDetail isVerified(Boolean isVerified) {
		this.isVerified = isVerified;
		return this;
	}

	/**
	 * When 'source' of property is FIELD_SURVEY then property should be verified by higher officials or during a work flow also property to be verified in some cases. This field to capture the verification status.
	 * @return isVerified
	 **/
	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public PropertyDetail verificationDate(String verificationDate) {
		this.verificationDate = verificationDate;
		return this;
	}

	/**
	 * verification date of the Property
	 * @return verificationDate
	 **/
	public String getVerificationDate() {
		return verificationDate;
	}

	public void setVerificationDate(String verificationDate) {
		this.verificationDate = verificationDate;
	}

	public PropertyDetail isExempted(Boolean isExempted) {
		this.isExempted = isExempted;
		return this;
	}

	/**
	 * Property can be exempted from tax for different reasons, this field captures the exempted status
	 * @return isExempted
	 **/
	public Boolean getIsExempted() {
		return isExempted;
	}

	public void setIsExempted(Boolean isExempted) {
		this.isExempted = isExempted;
	}

	public PropertyDetail exemptionReason(String exemptionReason) {
		this.exemptionReason = exemptionReason;
		return this;
	}

	/**
	 * exemption reason for the property
	 * @return exemptionReason
	 **/
	public String getExemptionReason() {
		return exemptionReason;
	}

	public void setExemptionReason(String exemptionReason) {
		this.exemptionReason = exemptionReason;
	}

	public PropertyDetail propertyType(String propertyType) {
		this.propertyType = propertyType;
		return this;
	}

	/**
	 * Type of a property like Private, Vacant Land, State Government, Central Government etc.
	 * @return propertyType
	 **/
	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public PropertyDetail category(String category) {
		this.category = category;
		return this;
	}

	/**
	 * category of the property like Residential, Non-Residential, etc.
	 * @return category
	 **/
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public PropertyDetail usage(String usage) {
		this.usage = usage;
		return this;
	}

	/**
	 * usage of the property
	 * @return usage
	 **/
	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public PropertyDetail department(String department) {
		this.department = department;
		return this;
	}

	/**
	 * department of the property which belongs to. This is applicable when property type is State Govternment or Central Government.
	 * @return department
	 **/
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public PropertyDetail apartment(String apartment) {
		this.apartment = apartment;
		return this;
	}

	/**
	 * apartment of the PropertyDetail
	 * @return apartment
	 **/
	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public PropertyDetail siteLength(Double siteLength) {
		this.siteLength = siteLength;
		return this;
	}

	/**
	 * length of the land
	 * @return siteLength
	 **/
	public Double getSiteLength() {
		return siteLength;
	}

	public void setSiteLength(Double siteLength) {
		this.siteLength = siteLength;
	}

	public PropertyDetail siteBreadth(Double siteBreadth) {
		this.siteBreadth = siteBreadth;
		return this;
	}

	/**
	 * breadth of the land
	 * @return siteBreadth
	 **/
	public Double getSiteBreadth() {
		return siteBreadth;
	}

	public void setSiteBreadth(Double siteBreadth) {
		this.siteBreadth = siteBreadth;
	}

	public PropertyDetail sitalArea(Double sitalArea) {
		this.sitalArea = sitalArea;
		return this;
	}

	/**
	 * sital area of the land
	 * @return sitalArea
	 **/
	public Double getSitalArea() {
		return sitalArea;
	}

	public void setSitalArea(Double sitalArea) {
		this.sitalArea = sitalArea;
	}

	public PropertyDetail totalBuiltupArea(Double totalBuiltupArea) {
		this.totalBuiltupArea = totalBuiltupArea;
		return this;
	}

	/**
	 * total builtup area of the property. If building has multiple floors, this is a sum of individual floor builtup area.
	 * @return totalBuiltupArea
	 **/
	public Double getTotalBuiltupArea() {
		return totalBuiltupArea;
	}

	public void setTotalBuiltupArea(Double totalBuiltupArea) {
		this.totalBuiltupArea = totalBuiltupArea;
	}

	public PropertyDetail undividedShare(Double undividedShare) {
		this.undividedShare = undividedShare;
		return this;
	}

	/**
	 * undivided share of the flat. In case of apartment this is valid.
	 * @return undividedShare
	 **/
	public Double getUndividedShare() {
		return undividedShare;
	}

	public void setUndividedShare(Double undividedShare) {
		this.undividedShare = undividedShare;
	}

	public PropertyDetail noOfFloors(Long noOfFloors) {
		this.noOfFloors = noOfFloors;
		return this;
	}

	/**
	 * no of floors in the property
	 * @return noOfFloors
	 **/
	public Long getNoOfFloors() {
		return noOfFloors;
	}

	public void setNoOfFloors(Long noOfFloors) {
		this.noOfFloors = noOfFloors;
	}

	public PropertyDetail isSuperStructure(Boolean isSuperStructure) {
		this.isSuperStructure = isSuperStructure;
		return this;
	}

	/**
	 * is property a super structure. If Land is ownned by one person and building constructed by one person then its called Super structure
	 * @return isSuperStructure
	 **/
	public Boolean getIsSuperStructure() {
		return isSuperStructure;
	}

	public void setIsSuperStructure(Boolean isSuperStructure) {
		this.isSuperStructure = isSuperStructure;
	}

	public PropertyDetail landOwner(String landOwner) {
		this.landOwner = landOwner;
		return this;
	}

	/**
	 * Name of the land owner in case property is Super structure
	 * @return landOwner
	 **/
	public String getLandOwner() {
		return landOwner;
	}

	public void setLandOwner(String landOwner) {
		this.landOwner = landOwner;
	}

	public PropertyDetail floorType(String floorType) {
		this.floorType = floorType;
		return this;
	}

	/**
	 * type of floor
	 * @return floorType
	 **/
	public String getFloorType() {
		return floorType;
	}

	public void setFloorType(String floorType) {
		this.floorType = floorType;
	}

	public PropertyDetail woodType(String woodType) {
		this.woodType = woodType;
		return this;
	}

	/**
	 * type of wood used in the property
	 * @return woodType
	 **/
	public String getWoodType() {
		return woodType;
	}

	public void setWoodType(String woodType) {
		this.woodType = woodType;
	}

	public PropertyDetail roofType(String roofType) {
		this.roofType = roofType;
		return this;
	}

	/**
	 * type of roof the property having
	 * @return roofType
	 **/
	public String getRoofType() {
		return roofType;
	}

	public void setRoofType(String roofType) {
		this.roofType = roofType;
	}

	public PropertyDetail wallType(String wallType) {
		this.wallType = wallType;
		return this;
	}

	/**
	 * type of walls the property having
	 * @return wallType
	 **/
	public String getWallType() {
		return wallType;
	}

	public void setWallType(String wallType) {
		this.wallType = wallType;
	}

	public PropertyDetail floors(List<Floor> floors) {
		this.floors = floors;
		return this;
	}

	public PropertyDetail addFloorsItem(Floor floorsItem) {
		this.floors.add(floorsItem);
		return this;
	}

	/**
	 * Floors
	 * @return floors
	 **/
	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}

	public PropertyDetail documents(List<Document> documents) {
		this.documents = documents;
		return this;
	}

	public PropertyDetail addDocumentsItem(Document documentsItem) {
		this.documents.add(documentsItem);
		return this;
	}

	/**
	 * The documents attached during assessment, modification or any transaction happened on the property.
	 * @return documents
	 **/
	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public PropertyDetail stateId(String stateId) {
		this.stateId = stateId;
		return this;
	}

	/**
	 * Work flow ref id.
	 * @return stateId
	 **/
	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public PropertyDetail applicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
		return this;
	}

	/**
	 * Acknowldgement number given to citizen on submitting the application for creation or modification of the property.
	 * @return applicationNo
	 **/
	public String getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public PropertyDetail workFlowDetails(WorkFlowDetails workFlowDetails) {
		this.workFlowDetails = workFlowDetails;
		return this;
	}

	/**
	 * Get workFlowDetails
	 * @return workFlowDetails
	 **/
	public WorkFlowDetails getWorkFlowDetails() {
		return workFlowDetails;
	}

	public void setWorkFlowDetails(WorkFlowDetails workFlowDetails) {
		this.workFlowDetails = workFlowDetails;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PropertyDetail propertyDetail = (PropertyDetail) o;
		return Objects.equals(this.id, propertyDetail.id) &&
				Objects.equals(this.source, propertyDetail.source) &&
				Objects.equals(this.regdDocNo, propertyDetail.regdDocNo) &&
				Objects.equals(this.regdDocDate, propertyDetail.regdDocDate) &&
				Objects.equals(this.reason, propertyDetail.reason) &&
				Objects.equals(this.status, propertyDetail.status) &&
				Objects.equals(this.isVerified, propertyDetail.isVerified) &&
				Objects.equals(this.verificationDate, propertyDetail.verificationDate) &&
				Objects.equals(this.isExempted, propertyDetail.isExempted) &&
				Objects.equals(this.exemptionReason, propertyDetail.exemptionReason) &&
				Objects.equals(this.propertyType, propertyDetail.propertyType) &&
				Objects.equals(this.category, propertyDetail.category) &&
				Objects.equals(this.usage, propertyDetail.usage) &&
				Objects.equals(this.department, propertyDetail.department) &&
				Objects.equals(this.apartment, propertyDetail.apartment) &&
				Objects.equals(this.siteLength, propertyDetail.siteLength) &&
				Objects.equals(this.siteBreadth, propertyDetail.siteBreadth) &&
				Objects.equals(this.sitalArea, propertyDetail.sitalArea) &&
				Objects.equals(this.totalBuiltupArea, propertyDetail.totalBuiltupArea) &&
				Objects.equals(this.undividedShare, propertyDetail.undividedShare) &&
				Objects.equals(this.noOfFloors, propertyDetail.noOfFloors) &&
				Objects.equals(this.isSuperStructure, propertyDetail.isSuperStructure) &&
				Objects.equals(this.landOwner, propertyDetail.landOwner) &&
				Objects.equals(this.floorType, propertyDetail.floorType) &&
				Objects.equals(this.woodType, propertyDetail.woodType) &&
				Objects.equals(this.roofType, propertyDetail.roofType) &&
				Objects.equals(this.wallType, propertyDetail.wallType) &&
				Objects.equals(this.floors, propertyDetail.floors) &&
				Objects.equals(this.documents, propertyDetail.documents) &&
				Objects.equals(this.stateId, propertyDetail.stateId) &&
				Objects.equals(this.applicationNo, propertyDetail.applicationNo) &&
				Objects.equals(this.workFlowDetails, propertyDetail.workFlowDetails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, source, regdDocNo, regdDocDate, reason, status, isVerified, verificationDate, isExempted, exemptionReason, propertyType, category, usage, department, apartment, siteLength, siteBreadth, sitalArea, totalBuiltupArea, undividedShare, noOfFloors, isSuperStructure, landOwner, floorType, woodType, roofType, wallType, floors, documents, stateId, applicationNo, workFlowDetails);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PropertyDetail {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    source: ").append(toIndentedString(source)).append("\n");
		sb.append("    regdDocNo: ").append(toIndentedString(regdDocNo)).append("\n");
		sb.append("    regdDocDate: ").append(toIndentedString(regdDocDate)).append("\n");
		sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    isVerified: ").append(toIndentedString(isVerified)).append("\n");
		sb.append("    verificationDate: ").append(toIndentedString(verificationDate)).append("\n");
		sb.append("    isExempted: ").append(toIndentedString(isExempted)).append("\n");
		sb.append("    exemptionReason: ").append(toIndentedString(exemptionReason)).append("\n");
		sb.append("    propertyType: ").append(toIndentedString(propertyType)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    usage: ").append(toIndentedString(usage)).append("\n");
		sb.append("    department: ").append(toIndentedString(department)).append("\n");
		sb.append("    apartment: ").append(toIndentedString(apartment)).append("\n");
		sb.append("    siteLength: ").append(toIndentedString(siteLength)).append("\n");
		sb.append("    siteBreadth: ").append(toIndentedString(siteBreadth)).append("\n");
		sb.append("    sitalArea: ").append(toIndentedString(sitalArea)).append("\n");
		sb.append("    totalBuiltupArea: ").append(toIndentedString(totalBuiltupArea)).append("\n");
		sb.append("    undividedShare: ").append(toIndentedString(undividedShare)).append("\n");
		sb.append("    noOfFloors: ").append(toIndentedString(noOfFloors)).append("\n");
		sb.append("    isSuperStructure: ").append(toIndentedString(isSuperStructure)).append("\n");
		sb.append("    landOwner: ").append(toIndentedString(landOwner)).append("\n");
		sb.append("    floorType: ").append(toIndentedString(floorType)).append("\n");
		sb.append("    woodType: ").append(toIndentedString(woodType)).append("\n");
		sb.append("    roofType: ").append(toIndentedString(roofType)).append("\n");
		sb.append("    wallType: ").append(toIndentedString(wallType)).append("\n");
		sb.append("    floors: ").append(toIndentedString(floors)).append("\n");
		sb.append("    documents: ").append(toIndentedString(documents)).append("\n");
		sb.append("    stateId: ").append(toIndentedString(stateId)).append("\n");
		sb.append("    applicationNo: ").append(toIndentedString(applicationNo)).append("\n");
		sb.append("    workFlowDetails: ").append(toIndentedString(workFlowDetails)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}

