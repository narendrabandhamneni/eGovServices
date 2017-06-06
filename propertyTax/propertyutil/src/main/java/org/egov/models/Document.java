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

	public Document id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * unique id of the ApplicationType.
	 * @return id
	 **/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Document documentType(DocumentType documentType) {
		this.documentType = documentType;
		return this;
	}

	/**
	 * Get documentType
	 * @return documentType
	 **/
	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public Document fileStore(String fileStore) {
		this.fileStore = fileStore;
		return this;
	}

	/**
	 * File store reference key.
	 * @return fileStore
	 **/
	public String getFileStore() {
		return fileStore;
	}

	public void setFileStore(String fileStore) {
		this.fileStore = fileStore;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Document document = (Document) o;
		return Objects.equals(this.id, document.id) &&
				Objects.equals(this.documentType, document.documentType) &&
				Objects.equals(this.fileStore, document.fileStore);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, documentType, fileStore);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Document {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    documentType: ").append(toIndentedString(documentType)).append("\n");
		sb.append("    fileStore: ").append(toIndentedString(fileStore)).append("\n");
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

