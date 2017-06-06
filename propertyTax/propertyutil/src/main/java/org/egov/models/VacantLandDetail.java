package org.egov.models;

import java.util.Objects;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * VacantLandDetail
 * Author : Narendra
 */
public class VacantLandDetail   {
  @JsonProperty("surveyNumber")
  @Size(min=4,max=64)
  private String surveyNumber = null;

  @JsonProperty("pattaNumber")
  @Size(min=4,max=64)
  private String pattaNumber = null;

  @JsonProperty("marketValue")
  private Double marketValue = null;

  @JsonProperty("capitalValue")
  private Double capitalValue = null;

  @JsonProperty("layoutApprovedAuth")
  @Size(min=4,max=64)
  private String layoutApprovedAuth = null;

  @JsonProperty("layoutPermissionNo")
  @Size(min=4,max=64)
  private String layoutPermissionNo = null;

  @JsonProperty("layoutPermissionDate")
  private String layoutPermissionDate = null;

  @JsonProperty("resdPlotArea")
  private Double resdPlotArea = null;

  @JsonProperty("nonResdPlotArea")
  private Double nonResdPlotArea = null;

  public VacantLandDetail surveyNumber(String surveyNumber) {
    this.surveyNumber = surveyNumber;
    return this;
  }

   /**
   * survey number of the Land
   * @return surveyNumber
  **/
  public String getSurveyNumber() {
    return surveyNumber;
  }

  public void setSurveyNumber(String surveyNumber) {
    this.surveyNumber = surveyNumber;
  }

  public VacantLandDetail pattaNumber(String pattaNumber) {
    this.pattaNumber = pattaNumber;
    return this;
  }

   /**
   * patta number of the Land
   * @return pattaNumber
  **/
  public String getPattaNumber() {
    return pattaNumber;
  }

  public void setPattaNumber(String pattaNumber) {
    this.pattaNumber = pattaNumber;
  }

  public VacantLandDetail marketValue(Double marketValue) {
    this.marketValue = marketValue;
    return this;
  }

   /**
   * market value of the Land
   * @return marketValue
  **/
  public Double getMarketValue() {
    return marketValue;
  }

  public void setMarketValue(Double marketValue) {
    this.marketValue = marketValue;
  }

  public VacantLandDetail capitalValue(Double capitalValue) {
    this.capitalValue = capitalValue;
    return this;
  }

   /**
   * capital value of the Land
   * @return capitalValue
  **/
  public Double getCapitalValue() {
    return capitalValue;
  }

  public void setCapitalValue(Double capitalValue) {
    this.capitalValue = capitalValue;
  }

  public VacantLandDetail layoutApprovedAuth(String layoutApprovedAuth) {
    this.layoutApprovedAuth = layoutApprovedAuth;
    return this;
  }

   /**
   * layout approved authority of the Land
   * @return layoutApprovedAuth
  **/
  public String getLayoutApprovedAuth() {
    return layoutApprovedAuth;
  }

  public void setLayoutApprovedAuth(String layoutApprovedAuth) {
    this.layoutApprovedAuth = layoutApprovedAuth;
  }

  public VacantLandDetail layoutPermissionNo(String layoutPermissionNo) {
    this.layoutPermissionNo = layoutPermissionNo;
    return this;
  }

   /**
   * layout permission no by approved authority for the Land
   * @return layoutPermissionNo
  **/
  public String getLayoutPermissionNo() {
    return layoutPermissionNo;
  }

  public void setLayoutPermissionNo(String layoutPermissionNo) {
    this.layoutPermissionNo = layoutPermissionNo;
  }

  public VacantLandDetail layoutPermissionDate(String layoutPermissionDate) {
    this.layoutPermissionDate = layoutPermissionDate;
    return this;
  }

   /**
   * layout permission date by approved authority for the Land
   * @return layoutPermissionDate
  **/
   public String getLayoutPermissionDate() {
    return layoutPermissionDate;
  }

  public void setLayoutPermissionDate(String layoutPermissionDate) {
    this.layoutPermissionDate = layoutPermissionDate;
  }

  public VacantLandDetail resdPlotArea(Double resdPlotArea) {
    this.resdPlotArea = resdPlotArea;
    return this;
  }

   /**
   * resd plot area of the land
   * @return resdPlotArea
  **/
   public Double getResdPlotArea() {
    return resdPlotArea;
  }

  public void setResdPlotArea(Double resdPlotArea) {
    this.resdPlotArea = resdPlotArea;
  }

  public VacantLandDetail nonResdPlotArea(Double nonResdPlotArea) {
    this.nonResdPlotArea = nonResdPlotArea;
    return this;
  }

   /**
   * non resd plot area of the land
   * @return nonResdPlotArea
  **/
  public Double getNonResdPlotArea() {
    return nonResdPlotArea;
  }

  public void setNonResdPlotArea(Double nonResdPlotArea) {
    this.nonResdPlotArea = nonResdPlotArea;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VacantLandDetail vacantLandDetail = (VacantLandDetail) o;
    return Objects.equals(this.surveyNumber, vacantLandDetail.surveyNumber) &&
        Objects.equals(this.pattaNumber, vacantLandDetail.pattaNumber) &&
        Objects.equals(this.marketValue, vacantLandDetail.marketValue) &&
        Objects.equals(this.capitalValue, vacantLandDetail.capitalValue) &&
        Objects.equals(this.layoutApprovedAuth, vacantLandDetail.layoutApprovedAuth) &&
        Objects.equals(this.layoutPermissionNo, vacantLandDetail.layoutPermissionNo) &&
        Objects.equals(this.layoutPermissionDate, vacantLandDetail.layoutPermissionDate) &&
        Objects.equals(this.resdPlotArea, vacantLandDetail.resdPlotArea) &&
        Objects.equals(this.nonResdPlotArea, vacantLandDetail.nonResdPlotArea);
  }

  @Override
  public int hashCode() {
    return Objects.hash(surveyNumber, pattaNumber, marketValue, capitalValue, layoutApprovedAuth, layoutPermissionNo, layoutPermissionDate, resdPlotArea, nonResdPlotArea);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VacantLandDetail {\n");
    
    sb.append("    surveyNumber: ").append(toIndentedString(surveyNumber)).append("\n");
    sb.append("    pattaNumber: ").append(toIndentedString(pattaNumber)).append("\n");
    sb.append("    marketValue: ").append(toIndentedString(marketValue)).append("\n");
    sb.append("    capitalValue: ").append(toIndentedString(capitalValue)).append("\n");
    sb.append("    layoutApprovedAuth: ").append(toIndentedString(layoutApprovedAuth)).append("\n");
    sb.append("    layoutPermissionNo: ").append(toIndentedString(layoutPermissionNo)).append("\n");
    sb.append("    layoutPermissionDate: ").append(toIndentedString(layoutPermissionDate)).append("\n");
    sb.append("    resdPlotArea: ").append(toIndentedString(resdPlotArea)).append("\n");
    sb.append("    nonResdPlotArea: ").append(toIndentedString(nonResdPlotArea)).append("\n");
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

