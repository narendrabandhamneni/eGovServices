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
 * A logical group of rooms on a floor
 * Author : Narendra
 */

public class Unit   {
	@JsonProperty("unitNo")
	@NotNull
	private Integer unitNo = null;

	/**
	 * type of the unit
	 */
	public enum UnitTypeEnum {
		FLAT("FLAT"),

		ROOM("ROOM");

		private String value;

		UnitTypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static UnitTypeEnum fromValue(String text) {
			for (UnitTypeEnum b : UnitTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("unitType")
	@Size(min=1,max=16)
	private UnitTypeEnum unitType = null;

	@JsonProperty("units")
	private List<Unit> units = new ArrayList<Unit>();

	@JsonProperty("length")
	private Double length = null;

	@JsonProperty("width")
	private Double width = null;

	@JsonProperty("builtupArea")
	@NotNull
	private Double builtupArea = null;

	@JsonProperty("assessableArea")
	private Double assessableArea = null;

	@JsonProperty("bpaBuiltupArea")
	private Double bpaBuiltupArea = null;

	@JsonProperty("bpaNo")
	@Size(min=1,max=16)
	private String bpaNo = null;

	@JsonProperty("bpaDate")
	private String bpaDate = null;

	@JsonProperty("usage")
	@NotNull
	@Size(min=1,max=16)
	private String usage = null;

	@JsonProperty("occupancy")
	@NotNull
	@Size(min=1,max=16)
	private String occupancy = null;

	@JsonProperty("occupierName")
	@Size(min=1,max=128)
	private String occupierName = null;

	@JsonProperty("firmName")
	@Size(min=1,max=128)
	private String firmName = null;

	@JsonProperty("rentCollected")
	private Double rentCollected = null;

	@JsonProperty("structure")
	@NotNull
	@Size(min=1,max=16)
	private String structure = null;

	@JsonProperty("age")
	@Size(min=1,max=16)
	private String age = null;

	@JsonProperty("exemptionReason")
	@Size(min=1,max=32)
	private String exemptionReason = null;

	@JsonProperty("isStructured")
	private Boolean isStructured = true;

	@JsonProperty("occupancyDate")
	private String occupancyDate = null;

	@JsonProperty("constCompletionDate")
	private String constCompletionDate = null;

	@JsonProperty("manualArv")
	private Double manualArv = null;

	@JsonProperty("arv")
	private Double arv = null;

	@JsonProperty("electricMeterNo")
	@Size(min=1,max=64)
	private String electricMeterNo = null;

	@JsonProperty("waterMeterNo")
	@Size(min=1,max=64)
	private String waterMeterNo = null;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;

	public Unit unitNo(Integer unitNo) {
		this.unitNo = unitNo;
		return this;
	}

	/**
	 * unit no. Some ULBs captures the room wise details in case in the same floor different rooms are used for different purposes.
	 * @return unitNo
	 **/

	public Integer getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(Integer unitNo) {
		this.unitNo = unitNo;
	}

	public Unit unitType(UnitTypeEnum unitType) {
		this.unitType = unitType;
		return this;
	}

	/**
	 * type of the unit
	 * @return unitType
	 **/

	public UnitTypeEnum getUnitType() {
		return unitType;
	}

	public void setUnitType(UnitTypeEnum unitType) {
		this.unitType = unitType;
	}

	public Unit units(List<Unit> units) {
		this.units = units;
		return this;
	}

	public Unit addUnitsItem(Unit unitsItem) {
		this.units.add(unitsItem);
		return this;
	}

	/**
	 * Flat(s) or Room(s) information. When unit is there inside a unit is a room.
	 * @return units
	 **/
	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

	public Unit length(Double length) {
		this.length = length;
		return this;
	}

	/**
	 * length of the Unit
	 * @return length
	 **/
	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Unit width(Double width) {
		this.width = width;
		return this;
	}

	/**
	 * width of the Unit
	 * @return width
	 **/
	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Unit builtupArea(Double builtupArea) {
		this.builtupArea = builtupArea;
		return this;
	}

	/**
	 * builtup area of the Unit
	 * @return builtupArea
	 **/
	
	public Double getBuiltupArea() {
		return builtupArea;
	}

	public void setBuiltupArea(Double builtupArea) {
		this.builtupArea = builtupArea;
	}

	public Unit assessableArea(Double assessableArea) {
		this.assessableArea = assessableArea;
		return this;
	}

	/**
	 * assessable area for the Unit. Some ULBs have their own logic to consider builtup area for tax calculation.
	 * @return assessableArea
	 **/
	public Double getAssessableArea() {
		return assessableArea;
	}

	public void setAssessableArea(Double assessableArea) {
		this.assessableArea = assessableArea;
	}

	public Unit bpaBuiltupArea(Double bpaBuiltupArea) {
		this.bpaBuiltupArea = bpaBuiltupArea;
		return this;
	}

	/**
	 * builtup area given during the Building plan approval of the Floor
	 * @return bpaBuiltupArea
	 **/
	public Double getBpaBuiltupArea() {
		return bpaBuiltupArea;
	}

	public void setBpaBuiltupArea(Double bpaBuiltupArea) {
		this.bpaBuiltupArea = bpaBuiltupArea;
	}

	public Unit bpaNo(String bpaNo) {
		this.bpaNo = bpaNo;
		return this;
	}

	/**
	 * Buidling plan approval no for the Floor
	 * @return bpaNo
	 **/
	public String getBpaNo() {
		return bpaNo;
	}

	public void setBpaNo(String bpaNo) {
		this.bpaNo = bpaNo;
	}

	public Unit bpaDate(String bpaDate) {
		this.bpaDate = bpaDate;
		return this;
	}

	/**
	 * Buidling plan approval date for the Floor
	 * @return bpaDate
	 **/
	public String getBpaDate() {
		return bpaDate;
	}

	public void setBpaDate(String bpaDate) {
		this.bpaDate = bpaDate;
	}

	public Unit usage(String usage) {
		this.usage = usage;
		return this;
	}

	/**
	 * usage of the Unit
	 * @return usage
	 **/
	
	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public Unit occupancy(String occupancy) {
		this.occupancy = occupancy;
		return this;
	}

	/**
	 * occupancy of the Unit
	 * @return occupancy
	 **/
	public String getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}

	public Unit occupierName(String occupierName) {
		this.occupierName = occupierName;
		return this;
	}

	/**
	 * Name of the occupier in a Unit
	 * @return occupierName
	 **/
	public String getOccupierName() {
		return occupierName;
	}

	public void setOccupierName(String occupierName) {
		this.occupierName = occupierName;
	}

	public Unit firmName(String firmName) {
		this.firmName = firmName;
		return this;
	}

	/**
	 * Name of the firm in a Unit
	 * @return firmName
	 **/
	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	public Unit rentCollected(Double rentCollected) {
		this.rentCollected = rentCollected;
		return this;
	}

	/**
	 * rent collected for the Unit it its given tenants are living.
	 * @return rentCollected
	 **/

	public Double getRentCollected() {
		return rentCollected;
	}

	public void setRentCollected(Double rentCollected) {
		this.rentCollected = rentCollected;
	}

	public Unit structure(String structure) {
		this.structure = structure;
		return this;
	}

	/**
	 * structure of the Unit
	 * @return structure
	 **/
	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public Unit age(String age) {
		this.age = age;
		return this;
	}

	/**
	 * age of the Unit
	 * @return age
	 **/
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Unit exemptionReason(String exemptionReason) {
		this.exemptionReason = exemptionReason;
		return this;
	}

	/**
	 * exemption reason for the Unit
	 * @return exemptionReason
	 **/
	public String getExemptionReason() {
		return exemptionReason;
	}

	public void setExemptionReason(String exemptionReason) {
		this.exemptionReason = exemptionReason;
	}

	public Unit isStructured(Boolean isStructured) {
		this.isStructured = isStructured;
		return this;
	}

	/**
	 * is Unit is structured. Some building may not be in square or rectangle or in a proper shape to calculate a builtup area.
	 * @return isStructured
	 **/
	public Boolean getIsStructured() {
		return isStructured;
	}

	public void setIsStructured(Boolean isStructured) {
		this.isStructured = isStructured;
	}

	public Unit occupancyDate(String occupancyDate) {
		this.occupancyDate = occupancyDate;
		return this;
	}

	/**
	 * occupancy date of the Unit
	 * @return occupancyDate
	 **/
	public String getOccupancyDate() {
		return occupancyDate;
	}

	public void setOccupancyDate(String occupancyDate) {
		this.occupancyDate = occupancyDate;
	}

	public Unit constCompletionDate(String constCompletionDate) {
		this.constCompletionDate = constCompletionDate;
		return this;
	}

	/**
	 * construction completion date of the Unit
	 * @return constCompletionDate
	 **/
	public String getConstCompletionDate() {
		return constCompletionDate;
	}

	public void setConstCompletionDate(String constCompletionDate) {
		this.constCompletionDate = constCompletionDate;
	}

	public Unit manualArv(Double manualArv) {
		this.manualArv = manualArv;
		return this;
	}

	/**
	 * manual arv for the Unit
	 * @return manualArv
	 **/
	public Double getManualArv() {
		return manualArv;
	}

	public void setManualArv(Double manualArv) {
		this.manualArv = manualArv;
	}

	public Unit arv(Double arv) {
		this.arv = arv;
		return this;
	}

	/**
	 * The system calculated arv for the Unit
	 * @return arv
	 **/
	public Double getArv() {
		return arv;
	}

	public void setArv(Double arv) {
		this.arv = arv;
	}

	public Unit electricMeterNo(String electricMeterNo) {
		this.electricMeterNo = electricMeterNo;
		return this;
	}

	/**
	 * electricity meter no for the Unit
	 * @return electricMeterNo
	 **/
	public String getElectricMeterNo() {
		return electricMeterNo;
	}

	public void setElectricMeterNo(String electricMeterNo) {
		this.electricMeterNo = electricMeterNo;
	}

	public Unit waterMeterNo(String waterMeterNo) {
		this.waterMeterNo = waterMeterNo;
		return this;
	}

	/**
	 * water meter no for the Unit
	 * @return waterMeterNo
	 **/
	public String getWaterMeterNo() {
		return waterMeterNo;
	}

	public void setWaterMeterNo(String waterMeterNo) {
		this.waterMeterNo = waterMeterNo;
	}

	public Unit auditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
		return this;
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
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Unit unit = (Unit) o;
		return Objects.equals(this.unitNo, unit.unitNo) &&
				Objects.equals(this.unitType, unit.unitType) &&
				Objects.equals(this.units, unit.units) &&
				Objects.equals(this.length, unit.length) &&
				Objects.equals(this.width, unit.width) &&
				Objects.equals(this.builtupArea, unit.builtupArea) &&
				Objects.equals(this.assessableArea, unit.assessableArea) &&
				Objects.equals(this.bpaBuiltupArea, unit.bpaBuiltupArea) &&
				Objects.equals(this.bpaNo, unit.bpaNo) &&
				Objects.equals(this.bpaDate, unit.bpaDate) &&
				Objects.equals(this.usage, unit.usage) &&
				Objects.equals(this.occupancy, unit.occupancy) &&
				Objects.equals(this.occupierName, unit.occupierName) &&
				Objects.equals(this.firmName, unit.firmName) &&
				Objects.equals(this.rentCollected, unit.rentCollected) &&
				Objects.equals(this.structure, unit.structure) &&
				Objects.equals(this.age, unit.age) &&
				Objects.equals(this.exemptionReason, unit.exemptionReason) &&
				Objects.equals(this.isStructured, unit.isStructured) &&
				Objects.equals(this.occupancyDate, unit.occupancyDate) &&
				Objects.equals(this.constCompletionDate, unit.constCompletionDate) &&
				Objects.equals(this.manualArv, unit.manualArv) &&
				Objects.equals(this.arv, unit.arv) &&
				Objects.equals(this.electricMeterNo, unit.electricMeterNo) &&
				Objects.equals(this.waterMeterNo, unit.waterMeterNo) &&
				Objects.equals(this.auditDetails, unit.auditDetails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(unitNo, unitType, units, length, width, builtupArea, assessableArea, bpaBuiltupArea, bpaNo, bpaDate, usage, occupancy, occupierName, firmName, rentCollected, structure, age, exemptionReason, isStructured, occupancyDate, constCompletionDate, manualArv, arv, electricMeterNo, waterMeterNo, auditDetails);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Unit {\n");

		sb.append("    unitNo: ").append(toIndentedString(unitNo)).append("\n");
		sb.append("    unitType: ").append(toIndentedString(unitType)).append("\n");
		sb.append("    units: ").append(toIndentedString(units)).append("\n");
		sb.append("    length: ").append(toIndentedString(length)).append("\n");
		sb.append("    width: ").append(toIndentedString(width)).append("\n");
		sb.append("    builtupArea: ").append(toIndentedString(builtupArea)).append("\n");
		sb.append("    assessableArea: ").append(toIndentedString(assessableArea)).append("\n");
		sb.append("    bpaBuiltupArea: ").append(toIndentedString(bpaBuiltupArea)).append("\n");
		sb.append("    bpaNo: ").append(toIndentedString(bpaNo)).append("\n");
		sb.append("    bpaDate: ").append(toIndentedString(bpaDate)).append("\n");
		sb.append("    usage: ").append(toIndentedString(usage)).append("\n");
		sb.append("    occupancy: ").append(toIndentedString(occupancy)).append("\n");
		sb.append("    occupierName: ").append(toIndentedString(occupierName)).append("\n");
		sb.append("    firmName: ").append(toIndentedString(firmName)).append("\n");
		sb.append("    rentCollected: ").append(toIndentedString(rentCollected)).append("\n");
		sb.append("    structure: ").append(toIndentedString(structure)).append("\n");
		sb.append("    age: ").append(toIndentedString(age)).append("\n");
		sb.append("    exemptionReason: ").append(toIndentedString(exemptionReason)).append("\n");
		sb.append("    isStructured: ").append(toIndentedString(isStructured)).append("\n");
		sb.append("    occupancyDate: ").append(toIndentedString(occupancyDate)).append("\n");
		sb.append("    constCompletionDate: ").append(toIndentedString(constCompletionDate)).append("\n");
		sb.append("    manualArv: ").append(toIndentedString(manualArv)).append("\n");
		sb.append("    arv: ").append(toIndentedString(arv)).append("\n");
		sb.append("    electricMeterNo: ").append(toIndentedString(electricMeterNo)).append("\n");
		sb.append("    waterMeterNo: ").append(toIndentedString(waterMeterNo)).append("\n");
		sb.append("    auditDetails: ").append(toIndentedString(auditDetails)).append("\n");
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

