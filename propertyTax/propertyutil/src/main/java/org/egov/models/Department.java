package org.egov.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * department
 * @author narendra
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

	private Integer id;
	
	@NotNull
	@Size(min=4,max=128)
	private String tenantId;
	
	@Size(min=4,max=16)
	@NotNull
	private String category;
	
	@NotNull
	@Size(min=4,max=128)
	private String name;
	
	@NotNull
	@Size(min=4,max=16)
	private String code;
	
	@Size(min=8,max=256)
	private String nameLocal;
	
	@Size(min=8,max=512)
	private String description;
	
	private Integer createdBy;
	
	private Long createdDate;
	
	private Integer lastModifiedBy;
	
	private Long lastModifiedDate;
	
}
