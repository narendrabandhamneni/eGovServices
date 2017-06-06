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

	public Unit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Unit(Integer unitNo, UnitTypeEnum unitType, Double length, Double width, Double builtupArea,
			Double assessableArea, Double bpaBuiltupArea, String bpaNo, String bpaDate, String usage, String occupancy,
			String occupierName, String firmName, Double rentCollected, String structure, String age,
			String exemptionReason, Boolean isStructured, String occupancyDate, String constCompletionDate,
			Double manualArv, Double arv, String electricMeterNo, String waterMeterNo, AuditDetails auditDetails) {
		super();
		this.unitNo = unitNo;
		this.unitType = unitType;
		this.length = length;
		this.width = width;
		this.builtupArea = builtupArea;
		this.assessableArea = assessableArea;
		this.bpaBuiltupArea = bpaBuiltupArea;
		this.bpaNo = bpaNo;
		this.bpaDate = bpaDate;
		this.usage = usage;
		this.occupancy = occupancy;
		this.occupierName = occupierName;
		this.firmName = firmName;
		this.rentCollected = rentCollected;
		this.structure = structure;
		this.age = age;
		this.exemptionReason = exemptionReason;
		this.isStructured = isStructured;
		this.occupancyDate = occupancyDate;
		this.constCompletionDate = constCompletionDate;
		this.manualArv = manualArv;
		this.arv = arv;
		this.electricMeterNo = electricMeterNo;
		this.waterMeterNo = waterMeterNo;
		this.auditDetails = auditDetails;
	}

	public Integer getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(Integer unitNo) {
		this.unitNo = unitNo;
	}

	public UnitTypeEnum getUnitType() {
		return unitType;
	}

	public void setUnitType(UnitTypeEnum unitType) {
		this.unitType = unitType;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getBuiltupArea() {
		return builtupArea;
	}

	public void setBuiltupArea(Double builtupArea) {
		this.builtupArea = builtupArea;
	}

	public Double getAssessableArea() {
		return assessableArea;
	}

	public void setAssessableArea(Double assessableArea) {
		this.assessableArea = assessableArea;
	}

	public Double getBpaBuiltupArea() {
		return bpaBuiltupArea;
	}

	public void setBpaBuiltupArea(Double bpaBuiltupArea) {
		this.bpaBuiltupArea = bpaBuiltupArea;
	}

	public String getBpaNo() {
		return bpaNo;
	}

	public void setBpaNo(String bpaNo) {
		this.bpaNo = bpaNo;
	}

	public String getBpaDate() {
		return bpaDate;
	}

	public void setBpaDate(String bpaDate) {
		this.bpaDate = bpaDate;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}

	public String getOccupierName() {
		return occupierName;
	}

	public void setOccupierName(String occupierName) {
		this.occupierName = occupierName;
	}

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	public Double getRentCollected() {
		return rentCollected;
	}

	public void setRentCollected(Double rentCollected) {
		this.rentCollected = rentCollected;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getExemptionReason() {
		return exemptionReason;
	}

	public void setExemptionReason(String exemptionReason) {
		this.exemptionReason = exemptionReason;
	}

	public Boolean getIsStructured() {
		return isStructured;
	}

	public void setIsStructured(Boolean isStructured) {
		this.isStructured = isStructured;
	}

	public String getOccupancyDate() {
		return occupancyDate;
	}

	public void setOccupancyDate(String occupancyDate) {
		this.occupancyDate = occupancyDate;
	}

	public String getConstCompletionDate() {
		return constCompletionDate;
	}

	public void setConstCompletionDate(String constCompletionDate) {
		this.constCompletionDate = constCompletionDate;
	}

	public Double getManualArv() {
		return manualArv;
	}

	public void setManualArv(Double manualArv) {
		this.manualArv = manualArv;
	}

	public Double getArv() {
		return arv;
	}

	public void setArv(Double arv) {
		this.arv = arv;
	}

	public String getElectricMeterNo() {
		return electricMeterNo;
	}

	public void setElectricMeterNo(String electricMeterNo) {
		this.electricMeterNo = electricMeterNo;
	}

	public String getWaterMeterNo() {
		return waterMeterNo;
	}

	public void setWaterMeterNo(String waterMeterNo) {
		this.waterMeterNo = waterMeterNo;
	}

	public AuditDetails getAuditDetails() {
		return auditDetails;
	}

	public void setAuditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
	}

	@Override
	public String toString() {
		return "Unit [unitNo=" + unitNo + ", unitType=" + unitType + ", length=" + length + ", width=" + width
				+ ", builtupArea=" + builtupArea + ", assessableArea=" + assessableArea + ", bpaBuiltupArea="
				+ bpaBuiltupArea + ", bpaNo=" + bpaNo + ", bpaDate=" + bpaDate + ", usage=" + usage + ", occupancy="
				+ occupancy + ", occupierName=" + occupierName + ", firmName=" + firmName + ", rentCollected="
				+ rentCollected + ", structure=" + structure + ", age=" + age + ", exemptionReason=" + exemptionReason
				+ ", isStructured=" + isStructured + ", occupancyDate=" + occupancyDate + ", constCompletionDate="
				+ constCompletionDate + ", manualArv=" + manualArv + ", arv=" + arv + ", electricMeterNo="
				+ electricMeterNo + ", waterMeterNo=" + waterMeterNo + ", auditDetails=" + auditDetails
				+ ", getUnitNo()=" + getUnitNo() + ", getUnitType()=" + getUnitType() + ", getLength()=" + getLength()
				+ ", getWidth()=" + getWidth() + ", getBuiltupArea()=" + getBuiltupArea() + ", getAssessableArea()="
				+ getAssessableArea() + ", getBpaBuiltupArea()=" + getBpaBuiltupArea() + ", getBpaNo()=" + getBpaNo()
				+ ", getBpaDate()=" + getBpaDate() + ", getUsage()=" + getUsage() + ", getOccupancy()=" + getOccupancy()
				+ ", getOccupierName()=" + getOccupierName() + ", getFirmName()=" + getFirmName()
				+ ", getRentCollected()=" + getRentCollected() + ", getStructure()=" + getStructure() + ", getAge()="
				+ getAge() + ", getExemptionReason()=" + getExemptionReason() + ", getIsStructured()="
				+ getIsStructured() + ", getOccupancyDate()=" + getOccupancyDate() + ", getConstCompletionDate()="
				+ getConstCompletionDate() + ", getManualArv()=" + getManualArv() + ", getArv()=" + getArv()
				+ ", getElectricMeterNo()=" + getElectricMeterNo() + ", getWaterMeterNo()=" + getWaterMeterNo()
				+ ", getAuditDetails()=" + getAuditDetails() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}


}

