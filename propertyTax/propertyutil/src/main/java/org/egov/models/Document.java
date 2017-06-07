package org.egov.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object holds list of documents attached during the transaciton for a agreement
 * Author : Narendra
 */


public class Document   {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("documentType")
	private DocumentType documentType = null;

	@JsonProperty("fileStore")
	private String fileStore = null;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;

	public Document(Long id, DocumentType documentType, String fileStore, AuditDetails auditDetails) {
		super();
		this.id = id;
		this.documentType = documentType;
		this.fileStore = fileStore;
		this.auditDetails = auditDetails;
	}

	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getFileStore() {
		return fileStore;
	}

	public void setFileStore(String fileStore) {
		this.fileStore = fileStore;
	}

	public AuditDetails getAuditDetails() {
		return auditDetails;
	}

	public void setAuditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", documentType=" + documentType + ", fileStore=" + fileStore + ", auditDetails="
				+ auditDetails + ", getId()=" + getId() + ", getDocumentType()=" + getDocumentType()
				+ ", getFileStore()=" + getFileStore() + ", getAuditDetails()=" + getAuditDetails() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}

