package org.egov.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A Object holds the basic data for a property
 */

public class Property   {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("tenantId")
	@NotNull
	@Size( min = 4, max = 128)
	private String tenantId = null;

	@JsonProperty("upicNumber")
	@NotNull
	@Size(min = 6, max = 128)
	private String upicNumber = null;

	@JsonProperty("oldUpicNumber")
	@Size(min = 4, max = 128)
	private String oldUpicNumber = null;

	@JsonProperty("vltUpicNumber")
	@Size(min = 4, max = 128)
	private String vltUpicNumber = null;

	/**
	 * New property comes into system either property is newly constructed or existing property got sub divided. Here the reason for creation will be captured.
	 */
	public enum CreationReasonEnum {
		NEWPROPERTY("NEWPROPERTY"),

		SUBDIVISION("SUBDIVISION");

		private String value;

		CreationReasonEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static CreationReasonEnum fromValue(String text) {
			for (CreationReasonEnum b : CreationReasonEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("creationReason")
	@Size(min = 1, max = 256)
	private CreationReasonEnum creationReason = null;

	@JsonProperty("address")
	@NotNull
	private Address address = null;

	@JsonProperty("owners")
	@Valid
	@NotNull
	private List<OwnerInfo> owners = new ArrayList<OwnerInfo>();

	@JsonProperty("propertyDetail")
	@Valid
	@NotNull
	private PropertyDetail propertyDetail = null;

	@JsonProperty("vacantLand")
	@Valid
	private VacantLandDetail vacantLand = null;

	@JsonProperty("assessmentDate")
	private String assessmentDate = null;

	@JsonProperty("occupancyDate")
	@NotNull
	private String occupancyDate = null;

	@JsonProperty("gisRefNo")
	@Size(min=4,max=32)
	private String gisRefNo = null;

	@JsonProperty("isAuthorised")
	private Boolean isAuthorised = true;

	@JsonProperty("isUnderWorkflow")
	private Boolean isUnderWorkflow = false;

	@JsonProperty("boundary")
	@NotNull
	private PropertyLocation boundary = null;

	@JsonProperty("active")
	private Boolean active = true;

	/**
	 * Property can be created from different channels Eg. System (properties created by ULB officials), CFC Counter (From citizen faciliation counters) etc. Here we are defining some known channels, there can be more client to client.
	 */
	public enum ChannelEnum {
		SYSTEM("SYSTEM"),

		CFC_COUNTER("CFC_COUNTER"),

		CITIZEN("CITIZEN");

		private String value;

		ChannelEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static ChannelEnum fromValue(String text) {
			for (ChannelEnum b : ChannelEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("channel")
	@NotNull
	@Size(min=4,max=16)
	private ChannelEnum channel = null;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;
	
	private String taxCalculations;
	
	private List<Demand> demands;
	
	public List<Demand> getDemands() {
		return demands;
	}

	public void setDemands(List<Demand> demands) {
		this.demands = demands;
	}

	public String getTaxCalculations() {
		return taxCalculations;
	}

	public void setTaxCalculations(String taxCalculations) {
		this.taxCalculations = taxCalculations;
	}

	/**
	 * Unique Identifier of the Property
	 * @return id
	 **/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * tenant id of the Property
	 * @return tenantId
	 **/
	
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}


	/**
	 * UPIC (Unique Property Identification Code) of the Property. This is a unique in system. This is mandatory but always be generated on the final approval.
	 * @return upicNumber
	 **/
	public String getUpicNumber() {
		return upicNumber;
	}

	public void setUpicNumber(String upicNumber) {
		this.upicNumber = upicNumber;
	}


	/**
	 * Old upic no of the Property. ULBs have the existing property in their system/manual records with their identification number, they want to continue the old reference number in this case the same identification number will be captured here.
	 * @return oldUpicNumber
	 **/
	public String getOldUpicNumber() {
		return oldUpicNumber;
	}

	public void setOldUpicNumber(String oldUpicNumber) {
		this.oldUpicNumber = oldUpicNumber;
	}


	/**
	 * Vacant lands also be assessed in system. If building constructed in the same vacant land. The Vacant land upicno will be captured here for a the new building.
	 * @return vltUpicNumber
	 **/

	public String getVltUpicNumber() {
		return vltUpicNumber;
	}

	public void setVltUpicNumber(String vltUpicNumber) {
		this.vltUpicNumber = vltUpicNumber;
	}

	/**
	 * New property comes into system either property is newly constructed or existing property got sub divided. Here the reason for creation will be captured.
	 * @return creationReason
	 **/

	public CreationReasonEnum getCreationReason() {
		return creationReason;
	}

	public void setCreationReason(CreationReasonEnum creationReason) {
		this.creationReason = creationReason;
	}

	/**
	 * Get address
	 * @return address
	 **/
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Property owners, these will be citizen users in system.
	 * @return owners
	 **/
	public List<OwnerInfo> getOwners() {
		return owners;
	}

	public void setOwners(List<OwnerInfo> owners) {
		this.owners = owners;
	}

	/**
	 * Get propertyDetail
	 * @return propertyDetail
	 **/
	public PropertyDetail getPropertyDetail() {
		return propertyDetail;
	}

	public void setPropertyDetail(PropertyDetail propertyDetail) {
		this.propertyDetail = propertyDetail;
	}

	/**
	 * Get vacantLand
	 * @return vacantLand
	 **/
	public VacantLandDetail getVacantLand() {
		return vacantLand;
	}

	public void setVacantLand(VacantLandDetail vacantLand) {
		this.vacantLand = vacantLand;
	}

	/**
	 * There will be work flow to create a new property in a system. The assessment date is the final approval and UPIC no generation date.
	 * @return assessmentDate
	 **/
	public String getAssessmentDate() {
		return assessmentDate;
	}

	public void setAssessmentDate(String assessmentDate) {
		this.assessmentDate = assessmentDate;
	}

	/**
	 * Property is constructed but the tax will be applicable only from the occupation date. System capture that date here.
	 * @return occupancyDate
	 **/
	public String getOccupancyDate() {
		return occupancyDate;
	}

	public void setOccupancyDate(String occupancyDate) {
		this.occupancyDate = occupancyDate;
	}

	/**
	 * Property tax system will be integrated with GIS system. Here we capture the GIS ref. no.
	 * @return gisRefNo
	 **/
	public String getGisRefNo() {
		return gisRefNo;
	}

	public void setGisRefNo(String gisRefNo) {
		this.gisRefNo = gisRefNo;
	}

	/**
	 * Property can be authorised or not authorised in a ULB depends on different parameters Eg. If there is Building plan approval property is a authorised property otherwise its a not a authorised property. System will capture the info here.
	 * @return isAuthorised
	 **/

	public Boolean getIsAuthorised() {
		return isAuthorised;
	}

	public void setIsAuthorised(Boolean isAuthorised) {
		this.isAuthorised = isAuthorised;
	}

	/**
	 * There are different transactions can be performed on a property and all the transactions goes through the work flow. If one workflow is happening system should not allow other work flow on a same property so, when any work flow starts we flag this field as true and when the same work flow ends we flag this field as false.
	 * @return isUnderWorkflow
	 **/

	public Boolean getIsUnderWorkflow() {
		return isUnderWorkflow;
	}

	public void setIsUnderWorkflow(Boolean isUnderWorkflow) {
		this.isUnderWorkflow = isUnderWorkflow;
	}

	/**
	 * Get boundary
	 * @return boundary
	 **/
	public PropertyLocation getBoundary() {
		return boundary;
	}

	public void setBoundary(PropertyLocation boundary) {
		this.boundary = boundary;
	}

	/**
	 * True if the property is active and False if the property is inactive.
	 * @return active
	 **/
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * Property can be created from different channels Eg. System (properties created by ULB officials), CFC Counter (From citizen faciliation counters) etc. Here we are defining some known channels, there can be more client to client.
	 * @return channel
	 **/

	
	public ChannelEnum getChannel() {
		return channel;
	}

	public void setChannel(ChannelEnum channel) {
		this.channel = channel;
	}

	/**
	 * Get auditDetails
	 * @return auditDetails
	 **/

	public AuditDetails getAuditDetails() {
		return auditDetails;
	}

	public void setAuditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((assessmentDate == null) ? 0 : assessmentDate.hashCode());
		result = prime * result + ((auditDetails == null) ? 0 : auditDetails.hashCode());
		result = prime * result + ((boundary == null) ? 0 : boundary.hashCode());
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result + ((creationReason == null) ? 0 : creationReason.hashCode());
		result = prime * result + ((demands == null) ? 0 : demands.hashCode());
		result = prime * result + ((gisRefNo == null) ? 0 : gisRefNo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isAuthorised == null) ? 0 : isAuthorised.hashCode());
		result = prime * result + ((isUnderWorkflow == null) ? 0 : isUnderWorkflow.hashCode());
		result = prime * result + ((occupancyDate == null) ? 0 : occupancyDate.hashCode());
		result = prime * result + ((oldUpicNumber == null) ? 0 : oldUpicNumber.hashCode());
		result = prime * result + ((owners == null) ? 0 : owners.hashCode());
		result = prime * result + ((propertyDetail == null) ? 0 : propertyDetail.hashCode());
		result = prime * result + ((taxCalculations == null) ? 0 : taxCalculations.hashCode());
		result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
		result = prime * result + ((upicNumber == null) ? 0 : upicNumber.hashCode());
		result = prime * result + ((vacantLand == null) ? 0 : vacantLand.hashCode());
		result = prime * result + ((vltUpicNumber == null) ? 0 : vltUpicNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (assessmentDate == null) {
			if (other.assessmentDate != null)
				return false;
		} else if (!assessmentDate.equals(other.assessmentDate))
			return false;
		if (auditDetails == null) {
			if (other.auditDetails != null)
				return false;
		} else if (!auditDetails.equals(other.auditDetails))
			return false;
		if (boundary == null) {
			if (other.boundary != null)
				return false;
		} else if (!boundary.equals(other.boundary))
			return false;
		if (channel != other.channel)
			return false;
		if (creationReason != other.creationReason)
			return false;
		if (demands == null) {
			if (other.demands != null)
				return false;
		} else if (!demands.equals(other.demands))
			return false;
		if (gisRefNo == null) {
			if (other.gisRefNo != null)
				return false;
		} else if (!gisRefNo.equals(other.gisRefNo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isAuthorised == null) {
			if (other.isAuthorised != null)
				return false;
		} else if (!isAuthorised.equals(other.isAuthorised))
			return false;
		if (isUnderWorkflow == null) {
			if (other.isUnderWorkflow != null)
				return false;
		} else if (!isUnderWorkflow.equals(other.isUnderWorkflow))
			return false;
		if (occupancyDate == null) {
			if (other.occupancyDate != null)
				return false;
		} else if (!occupancyDate.equals(other.occupancyDate))
			return false;
		if (oldUpicNumber == null) {
			if (other.oldUpicNumber != null)
				return false;
		} else if (!oldUpicNumber.equals(other.oldUpicNumber))
			return false;
		if (owners == null) {
			if (other.owners != null)
				return false;
		} else if (!owners.equals(other.owners))
			return false;
		if (propertyDetail == null) {
			if (other.propertyDetail != null)
				return false;
		} else if (!propertyDetail.equals(other.propertyDetail))
			return false;
		if (taxCalculations == null) {
			if (other.taxCalculations != null)
				return false;
		} else if (!taxCalculations.equals(other.taxCalculations))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		if (upicNumber == null) {
			if (other.upicNumber != null)
				return false;
		} else if (!upicNumber.equals(other.upicNumber))
			return false;
		if (vacantLand == null) {
			if (other.vacantLand != null)
				return false;
		} else if (!vacantLand.equals(other.vacantLand))
			return false;
		if (vltUpicNumber == null) {
			if (other.vltUpicNumber != null)
				return false;
		} else if (!vltUpicNumber.equals(other.vltUpicNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", tenantId=" + tenantId + ", upicNumber=" + upicNumber + ", oldUpicNumber="
				+ oldUpicNumber + ", vltUpicNumber=" + vltUpicNumber + ", creationReason=" + creationReason
				+ ", address=" + address + ", owners=" + owners + ", propertyDetail=" + propertyDetail + ", vacantLand="
				+ vacantLand + ", assessmentDate=" + assessmentDate + ", occupancyDate=" + occupancyDate + ", gisRefNo="
				+ gisRefNo + ", isAuthorised=" + isAuthorised + ", isUnderWorkflow=" + isUnderWorkflow + ", boundary="
				+ boundary + ", active=" + active + ", channel=" + channel + ", auditDetails=" + auditDetails
				+ ", taxCalculations=" + taxCalculations + ", demands=" + demands + "]";
	}


	
	
}

