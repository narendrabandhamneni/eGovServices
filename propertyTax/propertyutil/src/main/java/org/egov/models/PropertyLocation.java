package org.egov.models;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
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
	@Size(min=1,max=256)
	private String northBoundedBy = null;

	@JsonProperty("eastBoundedBy")
	@Size(min=1,max=256)
	private String eastBoundedBy = null;

	@JsonProperty("westBoundedBy")
	@Size(min=1,max=256)
	private String westBoundedBy = null;

	@JsonProperty("southBoundedBy")
	@Size(min=1,max=256)
	private String southBoundedBy = null;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;



	public PropertyLocation(Boundary revenueBoundary, Boundary locationBoundary, Boundary adminBoundary,
			String northBoundedBy, String eastBoundedBy, String westBoundedBy, String southBoundedBy,
			AuditDetails auditDetails) {
		super();
		this.revenueBoundary = revenueBoundary;
		this.locationBoundary = locationBoundary;
		this.adminBoundary = adminBoundary;
		this.northBoundedBy = northBoundedBy;
		this.eastBoundedBy = eastBoundedBy;
		this.westBoundedBy = westBoundedBy;
		this.southBoundedBy = southBoundedBy;
		this.auditDetails = auditDetails;
	}


	public PropertyLocation() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Boundary getRevenueBoundary() {
		return revenueBoundary;
	}


	public void setRevenueBoundary(Boundary revenueBoundary) {
		this.revenueBoundary = revenueBoundary;
	}


	public Boundary getLocationBoundary() {
		return locationBoundary;
	}


	public void setLocationBoundary(Boundary locationBoundary) {
		this.locationBoundary = locationBoundary;
	}


	public Boundary getAdminBoundary() {
		return adminBoundary;
	}


	public void setAdminBoundary(Boundary adminBoundary) {
		this.adminBoundary = adminBoundary;
	}


	public String getNorthBoundedBy() {
		return northBoundedBy;
	}


	public void setNorthBoundedBy(String northBoundedBy) {
		this.northBoundedBy = northBoundedBy;
	}


	public String getEastBoundedBy() {
		return eastBoundedBy;
	}


	public void setEastBoundedBy(String eastBoundedBy) {
		this.eastBoundedBy = eastBoundedBy;
	}


	public String getWestBoundedBy() {
		return westBoundedBy;
	}


	public void setWestBoundedBy(String westBoundedBy) {
		this.westBoundedBy = westBoundedBy;
	}


	public String getSouthBoundedBy() {
		return southBoundedBy;
	}


	public void setSouthBoundedBy(String southBoundedBy) {
		this.southBoundedBy = southBoundedBy;
	}


	public AuditDetails getAuditDetails() {
		return auditDetails;
	}


	public void setAuditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
	}




	@Override
	public String toString() {
		return "PropertyLocation [revenueBoundary=" + revenueBoundary + ", locationBoundary=" + locationBoundary
				+ ", adminBoundary=" + adminBoundary + ", northBoundedBy=" + northBoundedBy + ", eastBoundedBy="
				+ eastBoundedBy + ", westBoundedBy=" + westBoundedBy + ", southBoundedBy=" + southBoundedBy
				+ ", auditDetails=" + auditDetails + ", getRevenueBoundary()=" + getRevenueBoundary()
				+ ", getLocationBoundary()=" + getLocationBoundary() + ", getAdminBoundary()=" + getAdminBoundary()
				+ ", getNorthBoundedBy()=" + getNorthBoundedBy() + ", getEastBoundedBy()=" + getEastBoundedBy()
				+ ", getWestBoundedBy()=" + getWestBoundedBy() + ", getSouthBoundedBy()=" + getSouthBoundedBy()
				+ ", getAuditDetails()=" + getAuditDetails() + ", getAllBoundaries()=" + getAllBoundaries()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}


	/**
	 * Description : This is to get the searchType fields of the target class
	 * @author Narendra
	 * @param target
	 * @param searchType
	 * @return result
	 */
	public List<String> getFieldsOfType(Class<?> target, Class<?> searchType) {

		Field[] fields  = target.getDeclaredFields();
		List<String> result = new ArrayList<String>();

		for(Field field:fields){
			if(field.getType().equals(searchType)){
				result.add(searchType.getName());
			}
		}
		return result;
	}

	/**
	 * Description : This is to get the BoundaryType fields of the PropertyLocation class
	 * @author Narendra
	 * @return List<String>
	 */
	public List<String> getAllBoundaries(){
		return getFieldsOfType(PropertyLocation.class, Boundary.class); 
	}

}

