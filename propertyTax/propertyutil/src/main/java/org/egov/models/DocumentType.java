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

	public DocumentType id(Long id) {
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

	public DocumentType name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * name of the document
	 * @return name
	 **/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DocumentType application(ApplicationEnum application) {
		this.application = application;
		return this;
	}

	/**
	 * Application type.
	 * @return application
	 **/
	public ApplicationEnum getApplication() {
		return application;
	}

	public void setApplication(ApplicationEnum application) {
		this.application = application;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DocumentType documentType = (DocumentType) o;
		return Objects.equals(this.id, documentType.id) &&
				Objects.equals(this.name, documentType.name) &&
				Objects.equals(this.application, documentType.application);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, application);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DocumentType {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    application: ").append(toIndentedString(application)).append("\n");
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

