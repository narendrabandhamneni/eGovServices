package org.egov.models;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PropertyLocation {

	private Boundary revenueBoundary;
	
	private Boundary locationBoundary;
	
	private Boundary adminBoundary;
	
	@Size(min=1, max=256)
	private String northBoundedBy;

	@Size(min=1, max=256)
	private String eastBoundedBy;
	
	@Size(min=1, max=256)
	private String westBoundedBy;
	
	@Size(min=1, max=256)
	private String southBoundedBy;
	
}
