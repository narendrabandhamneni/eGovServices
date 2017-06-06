package org.egov.models;

import java.util.Objects;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Boundary details for a property. &#39;revenueBoundary&#39; is granular level Revenue heirarchy boundary, &#39;locationBoundary&#39; is granular level Location heirarchy boundary, &#39;adminBoundary&#39; is granular level Administration heirarchy boundary.
 * Author: Narendra
 */


public class PropertyLocation   {
	@JsonProperty("revenueBoundary")
	private Boundary revenueBoundary = null;

	@JsonProperty("locationBoundary")
	private Boundary locationBoundary = null;

	@JsonProperty("adminBoundary")
	private Boundary adminBoundary = null;

	@JsonProperty("northBoundedBy")
	private String northBoundedBy = null;

	@JsonProperty("eastBoundedBy")
	private String eastBoundedBy = null;

	@JsonProperty("westBoundedBy")
	private String westBoundedBy = null;

	@JsonProperty("southBoundedBy")
	private String southBoundedBy = null;

	public PropertyLocation revenueBoundary(Boundary revenueBoundary) {
		this.revenueBoundary = revenueBoundary;
		return this;
	}

	/**
	 * Get revenueBoundary
	 * @return revenueBoundary
	 **/
	public Boundary getRevenueBoundary() {
		return revenueBoundary;
	}

	public void setRevenueBoundary(Boundary revenueBoundary) {
		this.revenueBoundary = revenueBoundary;
	}

	public PropertyLocation locationBoundary(Boundary locationBoundary) {
		this.locationBoundary = locationBoundary;
		return this;
	}

	/**
	 * Get locationBoundary
	 * @return locationBoundary
	 **/
	public Boundary getLocationBoundary() {
		return locationBoundary;
	}

	public void setLocationBoundary(Boundary locationBoundary) {
		this.locationBoundary = locationBoundary;
	}

	public PropertyLocation adminBoundary(Boundary adminBoundary) {
		this.adminBoundary = adminBoundary;
		return this;
	}

	/**
	 * Get adminBoundary
	 * @return adminBoundary
	 **/
	public Boundary getAdminBoundary() {
		return adminBoundary;
	}

	public void setAdminBoundary(Boundary adminBoundary) {
		this.adminBoundary = adminBoundary;
	}

	public PropertyLocation northBoundedBy(String northBoundedBy) {
		this.northBoundedBy = northBoundedBy;
		return this;
	}

	/**
	 * property bounded by on north side
	 * @return northBoundedBy
	 **/
	@Size(min=1,max=256)
	public String getNorthBoundedBy() {
		return northBoundedBy;
	}

	public void setNorthBoundedBy(String northBoundedBy) {
		this.northBoundedBy = northBoundedBy;
	}

	public PropertyLocation eastBoundedBy(String eastBoundedBy) {
		this.eastBoundedBy = eastBoundedBy;
		return this;
	}

	/**
	 * property bounded by on east side
	 * @return eastBoundedBy
	 **/
	@Size(min=1,max=256)
	public String getEastBoundedBy() {
		return eastBoundedBy;
	}

	public void setEastBoundedBy(String eastBoundedBy) {
		this.eastBoundedBy = eastBoundedBy;
	}

	public PropertyLocation westBoundedBy(String westBoundedBy) {
		this.westBoundedBy = westBoundedBy;
		return this;
	}

	/**
	 * property bounded by on west side
	 * @return westBoundedBy
	 **/
	@Size(min=1,max=256)
	public String getWestBoundedBy() {
		return westBoundedBy;
	}

	public void setWestBoundedBy(String westBoundedBy) {
		this.westBoundedBy = westBoundedBy;
	}

	public PropertyLocation southBoundedBy(String southBoundedBy) {
		this.southBoundedBy = southBoundedBy;
		return this;
	}

	/**
	 * property bounded by on south side
	 * @return southBoundedBy
	 **/
	@Size(min=1,max=256)
	public String getSouthBoundedBy() {
		return southBoundedBy;
	}

	public void setSouthBoundedBy(String southBoundedBy) {
		this.southBoundedBy = southBoundedBy;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PropertyLocation propertyLocation = (PropertyLocation) o;
		return Objects.equals(this.revenueBoundary, propertyLocation.revenueBoundary) &&
				Objects.equals(this.locationBoundary, propertyLocation.locationBoundary) &&
				Objects.equals(this.adminBoundary, propertyLocation.adminBoundary) &&
				Objects.equals(this.northBoundedBy, propertyLocation.northBoundedBy) &&
				Objects.equals(this.eastBoundedBy, propertyLocation.eastBoundedBy) &&
				Objects.equals(this.westBoundedBy, propertyLocation.westBoundedBy) &&
				Objects.equals(this.southBoundedBy, propertyLocation.southBoundedBy);
	}

	@Override
	public int hashCode() {
		return Objects.hash(revenueBoundary, locationBoundary, adminBoundary, northBoundedBy, eastBoundedBy, westBoundedBy, southBoundedBy);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PropertyLocation {\n");

		sb.append("    revenueBoundary: ").append(toIndentedString(revenueBoundary)).append("\n");
		sb.append("    locationBoundary: ").append(toIndentedString(locationBoundary)).append("\n");
		sb.append("    adminBoundary: ").append(toIndentedString(adminBoundary)).append("\n");
		sb.append("    northBoundedBy: ").append(toIndentedString(northBoundedBy)).append("\n");
		sb.append("    eastBoundedBy: ").append(toIndentedString(eastBoundedBy)).append("\n");
		sb.append("    westBoundedBy: ").append(toIndentedString(westBoundedBy)).append("\n");
		sb.append("    southBoundedBy: ").append(toIndentedString(southBoundedBy)).append("\n");
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

