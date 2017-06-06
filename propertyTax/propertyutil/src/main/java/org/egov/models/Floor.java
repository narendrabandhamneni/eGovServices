package org.egov.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * The floor details. The Floor contains either Flats in case of apartment or Rooms in case of group or individual house.
 */

public class Floor   {
  @JsonProperty("floorNo")
  @NotNull
  @Size(min=1,max=16)
  private String floorNo = null;

  @JsonProperty("units")
  @Valid
  private List<Unit> units = new ArrayList<Unit>();

  @JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;

public Floor(String floorNo, List<Unit> units, AuditDetails auditDetails) {
	super();
	this.floorNo = floorNo;
	this.units = units;
	this.auditDetails = auditDetails;
}

public Floor() {
	super();
	// TODO Auto-generated constructor stub
}

public String getFloorNo() {
	return floorNo;
}

public void setFloorNo(String floorNo) {
	this.floorNo = floorNo;
}

public List<Unit> getUnits() {
	return units;
}

public void setUnits(List<Unit> units) {
	this.units = units;
}

public AuditDetails getAuditDetails() {
	return auditDetails;
}

public void setAuditDetails(AuditDetails auditDetails) {
	this.auditDetails = auditDetails;
}

@Override
public String toString() {
	return "Floor [floorNo=" + floorNo + ", units=" + units + ", auditDetails=" + auditDetails + ", getFloorNo()="
			+ getFloorNo() + ", getUnits()=" + getUnits() + ", getAuditDetails()=" + getAuditDetails() + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}
  
  
}

