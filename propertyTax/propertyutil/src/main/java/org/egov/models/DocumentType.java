package org.egov.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This object holds type of documents to be uploaded during the transaction for each application type.
 * Author : Narendra
 */

public class DocumentType   {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("name")
	private String name = null;

	/**
	 * Application type.
	 */
	public enum ApplicationEnum {
		CREATE("CREATE"),

		RENEWAL("RENEWAL"),

		EVICTION("EVICTION"),

		CANCEL("CANCEL");

		private String value;

		ApplicationEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static ApplicationEnum fromValue(String text) {
			for (ApplicationEnum b : ApplicationEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("application")
	private ApplicationEnum application = null;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;

	public DocumentType(Long id, String name, ApplicationEnum application, AuditDetails auditDetails) {
		super();
		this.id = id;
		this.name = name;
		this.application = application;
		this.auditDetails = auditDetails;
	}

	public DocumentType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ApplicationEnum getApplication() {
		return application;
	}

	public void setApplication(ApplicationEnum application) {
		this.application = application;
	}

	public AuditDetails getAuditDetails() {
		return auditDetails;
	}

	public void setAuditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
	}

	@Override
	public String toString() {
		return "DocumentType [id=" + id + ", name=" + name + ", application=" + application + ", auditDetails="
				+ auditDetails + ", getId()=" + getId() + ", getName()=" + getName() + ", getApplication()="
				+ getApplication() + ", getAuditDetails()=" + getAuditDetails() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}

