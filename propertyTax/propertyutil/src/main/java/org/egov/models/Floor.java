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

  public Floor floorNo(String floorNo) {
    this.floorNo = floorNo;
    return this;
  }

   /**
   * floor no for the floor
   * @return floorNo
  **/
  public String getFloorNo() {
    return floorNo;
  }

  public void setFloorNo(String floorNo) {
    this.floorNo = floorNo;
  }

  public Floor units(List<Unit> units) {
    this.units = units;
    return this;
  }

  public Floor addUnitsItem(Unit unitsItem) {
    this.units.add(unitsItem);
    return this;
  }

   /**
   * Flat(s) or Room(s) information on a floor or in a Flat respectively.
   * @return units
  **/
   public List<Unit> getUnits() {
    return units;
  }

  public void setUnits(List<Unit> units) {
    this.units = units;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Floor floor = (Floor) o;
    return Objects.equals(this.floorNo, floor.floorNo) &&
        Objects.equals(this.units, floor.units);
  }

  @Override
  public int hashCode() {
    return Objects.hash(floorNo, units);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Floor {\n");
    
    sb.append("    floorNo: ").append(toIndentedString(floorNo)).append("\n");
    sb.append("    units: ").append(toIndentedString(units)).append("\n");
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

