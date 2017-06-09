package org.egov.models;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WallType
 */


public class WallType   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("tenantId")
  @NotNull
  @Size(min=4,max=128)
  private String tenantId = null;

  @JsonProperty("name")
  @NotNull
  @Size(min=4,max=128)
  private String name = null;

  @JsonProperty("code")
  @NotNull
  @Size(min=4,max=16)
  private String code = null;

  @JsonProperty("nameLocal")
  @Size(min=8,max=256)
  private String nameLocal = null;

  @JsonProperty("description")
  @Size(min=8,max=512)
  private String description = null;

  @JsonProperty("auditDetails")
  private AuditDetails auditDetails = null;

  public WallType id(Long id) {
    this.id = id;
    return this;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public WallType tenantId(String tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }

  public WallType name(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public WallType code(String code) {
    this.code = code;
    return this;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public WallType nameLocal(String nameLocal) {
    this.nameLocal = nameLocal;
    return this;
  }

  public String getNameLocal() {
    return nameLocal;
  }

  public void setNameLocal(String nameLocal) {
    this.nameLocal = nameLocal;
  }

  public WallType description(String description) {
    this.description = description;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public WallType auditDetails(AuditDetails auditDetails) {
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
    WallType wallType = (WallType) o;
    return Objects.equals(this.id, wallType.id) &&
        Objects.equals(this.tenantId, wallType.tenantId) &&
        Objects.equals(this.name, wallType.name) &&
        Objects.equals(this.code, wallType.code) &&
        Objects.equals(this.nameLocal, wallType.nameLocal) &&
        Objects.equals(this.description, wallType.description) &&
        Objects.equals(this.auditDetails, wallType.auditDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tenantId, name, code, nameLocal, description, auditDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WallType {\n");
    
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

  
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


