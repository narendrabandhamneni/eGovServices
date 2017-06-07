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

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;

	public VacantLandDetail(String surveyNumber, String pattaNumber, Double marketValue, Double capitalValue,
			String layoutApprovedAuth, String layoutPermissionNo, String layoutPermissionDate, Double resdPlotArea,
			Double nonResdPlotArea, AuditDetails auditDetails) {
		super();
		this.surveyNumber = surveyNumber;
		this.pattaNumber = pattaNumber;
		this.marketValue = marketValue;
		this.capitalValue = capitalValue;
		this.layoutApprovedAuth = layoutApprovedAuth;
		this.layoutPermissionNo = layoutPermissionNo;
		this.layoutPermissionDate = layoutPermissionDate;
		this.resdPlotArea = resdPlotArea;
		this.nonResdPlotArea = nonResdPlotArea;
		this.auditDetails = auditDetails;
	}

	public VacantLandDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSurveyNumber() {
		return surveyNumber;
	}

	public void setSurveyNumber(String surveyNumber) {
		this.surveyNumber = surveyNumber;
	}

	public String getPattaNumber() {
		return pattaNumber;
	}

	public void setPattaNumber(String pattaNumber) {
		this.pattaNumber = pattaNumber;
	}

	public Double getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(Double marketValue) {
		this.marketValue = marketValue;
	}

	public Double getCapitalValue() {
		return capitalValue;
	}

	public void setCapitalValue(Double capitalValue) {
		this.capitalValue = capitalValue;
	}

	public String getLayoutApprovedAuth() {
		return layoutApprovedAuth;
	}

	public void setLayoutApprovedAuth(String layoutApprovedAuth) {
		this.layoutApprovedAuth = layoutApprovedAuth;
	}

	public String getLayoutPermissionNo() {
		return layoutPermissionNo;
	}

	public void setLayoutPermissionNo(String layoutPermissionNo) {
		this.layoutPermissionNo = layoutPermissionNo;
	}

	public String getLayoutPermissionDate() {
		return layoutPermissionDate;
	}

	public void setLayoutPermissionDate(String layoutPermissionDate) {
		this.layoutPermissionDate = layoutPermissionDate;
	}

	public Double getResdPlotArea() {
		return resdPlotArea;
	}

	public void setResdPlotArea(Double resdPlotArea) {
		this.resdPlotArea = resdPlotArea;
	}

	public Double getNonResdPlotArea() {
		return nonResdPlotArea;
	}

	public void setNonResdPlotArea(Double nonResdPlotArea) {
		this.nonResdPlotArea = nonResdPlotArea;
	}

	public AuditDetails getAuditDetails() {
		return auditDetails;
	}

	public void setAuditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
	}

	@Override
	public String toString() {
		return "VacantLandDetail [surveyNumber=" + surveyNumber + ", pattaNumber=" + pattaNumber + ", marketValue="
				+ marketValue + ", capitalValue=" + capitalValue + ", layoutApprovedAuth=" + layoutApprovedAuth
				+ ", layoutPermissionNo=" + layoutPermissionNo + ", layoutPermissionDate=" + layoutPermissionDate
				+ ", resdPlotArea=" + resdPlotArea + ", nonResdPlotArea=" + nonResdPlotArea + ", auditDetails="
				+ auditDetails + ", getSurveyNumber()=" + getSurveyNumber() + ", getPattaNumber()=" + getPattaNumber()
				+ ", getMarketValue()=" + getMarketValue() + ", getCapitalValue()=" + getCapitalValue()
				+ ", getLayoutApprovedAuth()=" + getLayoutApprovedAuth() + ", getLayoutPermissionNo()="
				+ getLayoutPermissionNo() + ", getLayoutPermissionDate()=" + getLayoutPermissionDate()
				+ ", getResdPlotArea()=" + getResdPlotArea() + ", getNonResdPlotArea()=" + getNonResdPlotArea()
				+ ", getAuditDetails()=" + getAuditDetails() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}

