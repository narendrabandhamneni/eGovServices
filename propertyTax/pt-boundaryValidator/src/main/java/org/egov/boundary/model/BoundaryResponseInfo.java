package org.egov.boundary.model;

import org.egov.models.RequestInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoundaryResponseInfo {
	
	private RequestInfo requestInfo;
	
	private Boundary boundary;
	
}
