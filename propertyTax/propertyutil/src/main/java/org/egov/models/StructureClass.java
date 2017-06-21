package org.egov.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * StructureClass
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StructureClass {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("tenantId")
	@NotNull
	@Size(min = 8, max = 128)
	private String tenantId = null;

	@JsonProperty("name")
	@NotNull
	@Size(min = 4, max = 128)
	private String name = null;

	@JsonProperty("code")
	@NotNull
	@Size(min = 4, max = 16)
	private String code = null;

	@JsonProperty("nameLocal")
	@Size(min = 8, max = 256)
	private String nameLocal = null;

	@JsonProperty("description")
	@Size(min = 8, max = 512)
	private String description = null;

	@JsonProperty("active")
	private Boolean active = null;

	@JsonProperty("orderNumber")
	private Integer orderNumber = null;

	@JsonIgnore
	@JsonProperty("data")
	private String data;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;
}
