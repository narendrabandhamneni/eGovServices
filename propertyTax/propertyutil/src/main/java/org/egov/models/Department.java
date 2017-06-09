package org.egov.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * department
 * 
 * @author narendra
 *
 */

public class Department {

	private Long id;

	@NotNull
	@Size(min = 4, max = 128)
	private String tenantId;

	@Size(min = 4, max = 16)
	@NotNull
	private String category;

	@NotNull
	@Size(min = 4, max = 128)
	private String name;

	@NotNull
	@Size(min = 4, max = 16)
	private String code;

	@Size(min = 8, max = 256)
	private String nameLocal;

	@Size(min = 8, max = 512)
	private String description;

	private AuditDetails auditDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNameLocal() {
		return nameLocal;
	}

	public void setNameLocal(String nameLocal) {
		this.nameLocal = nameLocal;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AuditDetails getAuditDetails() {
		return auditDetails;
	}

	public void setAuditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auditDetails == null) ? 0 : auditDetails.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nameLocal == null) ? 0 : nameLocal.hashCode());
		result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (auditDetails == null) {
			if (other.auditDetails != null)
				return false;
		} else if (!auditDetails.equals(other.auditDetails))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nameLocal == null) {
			if (other.nameLocal != null)
				return false;
		} else if (!nameLocal.equals(other.nameLocal))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", tenantId=" + tenantId + ", category=" + category + ", name=" + name
				+ ", code=" + code + ", nameLocal=" + nameLocal + ", description=" + description + ", auditDetails="
				+ auditDetails + ", getId()=" + getId() + ", getTenantId()=" + getTenantId() + ", getCategory()="
				+ getCategory() + ", getName()=" + getName() + ", getCode()=" + getCode() + ", getNameLocal()="
				+ getNameLocal() + ", getDescription()=" + getDescription() + ", getAuditDetails()=" + getAuditDetails()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}

	public Department(Long id, String tenantId, String category, String name, String code, String nameLocal,
			String description, AuditDetails auditDetails) {
		super();
		this.id = id;
		this.tenantId = tenantId;
		this.category = category;
		this.name = name;
		this.code = code;
		this.nameLocal = nameLocal;
		this.description = description;
		this.auditDetails = auditDetails;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

}
