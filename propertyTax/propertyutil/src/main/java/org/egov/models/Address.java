package org.egov.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Address
 * Author : Narendra
 */


public class Address   {
	@JsonProperty("tenantId")
	private String tenantId = null;

	@JsonProperty("latitude")
	private Double latitude = null;

	@JsonProperty("longitude")
	private Double longitude = null;

	@JsonProperty("addressId")
	private String addressId = null;

	@JsonProperty("addressNumber")
	private String addressNumber = null;

	@JsonProperty("addressLine1")
	private String addressLine1 = null;

	@JsonProperty("addressLine2")
	private String addressLine2 = null;

	@JsonProperty("landmark")
	private String landmark = null;

	@JsonProperty("city")
	private String city = null;

	@JsonProperty("pincode")
	private String pincode = null;

	@JsonProperty("detail")
	private String detail = null;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;



	public Address(String tenantId, Double latitude, Double longitude, String addressId, String addressNumber,
			String addressLine1, String addressLine2, String landmark, String city, String pincode, String detail,
			AuditDetails auditDetails) {
		super();
		this.tenantId = tenantId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.addressId = addressId;
		this.addressNumber = addressNumber;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.landmark = landmark;
		this.city = city;
		this.pincode = pincode;
		this.detail = detail;
		this.auditDetails = auditDetails;
	}



	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public AuditDetails getAuditDetails() {
		return auditDetails;
	}

	public void setAuditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
	}

	@Override
	public String toString() {
		return "Address [tenantId=" + tenantId + ", latitude=" + latitude + ", longitude=" + longitude + ", addressId="
				+ addressId + ", addressNumber=" + addressNumber + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", landmark=" + landmark + ", city=" + city + ", pincode=" + pincode + ", detail="
				+ detail + ", auditDetails=" + auditDetails + ", getTenantId()=" + getTenantId() + ", getLatitude()="
				+ getLatitude() + ", getLongitude()=" + getLongitude() + ", getAddressId()=" + getAddressId()
				+ ", getAddressNumber()=" + getAddressNumber() + ", getAddressLine1()=" + getAddressLine1()
				+ ", getAddressLine2()=" + getAddressLine2() + ", getLandmark()=" + getLandmark() + ", getCity()="
				+ getCity() + ", getPincode()=" + getPincode() + ", getDetail()=" + getDetail() + ", getAuditDetails()="
				+ getAuditDetails() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


}

