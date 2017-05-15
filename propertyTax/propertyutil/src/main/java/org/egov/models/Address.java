package org.egov.models;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Address
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Address   {
 
  private String id ;

 
  private String houseNoBldgApt ;

  
  private String streetRoadLine ;

 
  private String landmark;
  

  private String areaLocalitySector ;

 
  private String cityTownVillage ;


  private String district;


  private String subDistrict;


  private String postOffice;


  private String state;


  private String country;


  private String pinCode;

  private String type;


  private String tenantId;

 


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(this.id, address.id) &&
        Objects.equals(this.houseNoBldgApt, address.houseNoBldgApt) &&
        Objects.equals(this.streetRoadLine, address.streetRoadLine) &&
        Objects.equals(this.landmark, address.landmark) &&
        Objects.equals(this.areaLocalitySector, address.areaLocalitySector) &&
        Objects.equals(this.cityTownVillage, address.cityTownVillage) &&
        Objects.equals(this.district, address.district) &&
        Objects.equals(this.subDistrict, address.subDistrict) &&
        Objects.equals(this.postOffice, address.postOffice) &&
        Objects.equals(this.state, address.state) &&
        Objects.equals(this.country, address.country) &&
        Objects.equals(this.pinCode, address.pinCode) &&
        Objects.equals(this.type, address.type) &&
        Objects.equals(this.tenantId, address.tenantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, houseNoBldgApt, streetRoadLine, landmark, areaLocalitySector, cityTownVillage, district, subDistrict, postOffice, state, country, pinCode, type, tenantId);
  }


}

