package org.egov.models;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FloorType   {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("tenantId")
	private String tenantId = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("code")
	private String code = null;

	@JsonProperty("nameLocal")
	private String nameLocal = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;

	public FloorType id(Long id) {
		this.id = id;
		return this;
	}


	@NotNull
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FloorType tenantId(String tenantId) {
		this.tenantId = tenantId;
		return this;
	}


	@NotNull
	@Size(min=4,max=128)
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public FloorType name(String name) {
		this.name = name;
		return this;
	}


	@NotNull
	@Size(min=4,max=128)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FloorType code(String code) {
		this.code = code;
		return this;
	}

	@NotNull
	@Size(min=4,max=16)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public FloorType nameLocal(String nameLocal) {
		this.nameLocal = nameLocal;
		return this;
	}


	@Size(min=8,max=256)
	public String getNameLocal() {
		return nameLocal;
	}

	public void setNameLocal(String nameLocal) {
		this.nameLocal = nameLocal;
	}

	public FloorType description(String description) {
		this.description = description;
		return this;
	}


	@Size(min=8,max=512)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FloorType auditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
		return this;
	}


	public AuditDetails getAuditDetails() {
		return auditDetails;
	}

	public void setAuditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FloorType floorType = (FloorType) o;
		return Objects.equals(this.id, floorType.id) &&
				Objects.equals(this.tenantId, floorType.tenantId) &&
				Objects.equals(this.name, floorType.name) &&
				Objects.equals(this.code, floorType.code) &&
				Objects.equals(this.nameLocal, floorType.nameLocal) &&
				Objects.equals(this.description, floorType.description) &&
				Objects.equals(this.auditDetails, floorType.auditDetails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tenantId, name, code, nameLocal, description, auditDetails);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class FloorType {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    nameLocal: ").append(toIndentedString(nameLocal)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    auditDetails: ").append(toIndentedString(auditDetails)).append("\n");
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


