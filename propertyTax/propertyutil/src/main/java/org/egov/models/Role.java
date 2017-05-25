package org.egov.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Role
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {
	@Max(value =32)
	@Min(value=1)
	private String name;

	private String description;

	@Max(value =32)
	@Min(value=1)
	private String code;

	private String id;

	private Integer createdBy;

	private String createdDate;

	private Integer lastModifiedBy;

	private String lastModifiedDate;

	private String tenantId;

}
